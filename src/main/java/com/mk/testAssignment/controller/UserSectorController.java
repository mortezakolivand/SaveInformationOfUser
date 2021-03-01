package com.mk.testAssignment.controller;

import com.mk.testAssignment.dto.SectorDTO;
import com.mk.testAssignment.dto.UserDTO;
import com.mk.testAssignment.servic.SectorService;
import com.mk.testAssignment.servic.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class UserSectorController {

    @Autowired
    private SectorService sectorService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("allSectors", getSectorList());
        return "index"; //view
    }

    private List<SectorDTO> getSectorList(){
        List<SectorDTO> dtoList = sectorService.findAll();
        dtoList.stream().forEach(sectorDTO -> {
            if(sectorDTO.getSelectLevel()>0){
                StringBuilder result = new StringBuilder();
                String spaces = "  -  ";
                for (int i=1 ; i<=sectorDTO.getSelectLevel();i++){
                    result.append(spaces);
                }
                result.append(sectorDTO.getTitle());
                sectorDTO.setTitle(result.toString());
            }
        });
        return dtoList;
    }

    @GetMapping(value = "/users")
    public String users(Model model){
        findAllUsers(model);
        return "users";
    }

    @GetMapping(value = "/editUser/{id}")
    public String editUser(@PathVariable("id") String id, Model model){
        System.out.println("this is my id "+ id);
        UserDTO userDTO = userService.findById(Integer.valueOf(id));
        if (userDTO != null && userDTO.getSectorId() != null){
            model.addAttribute("userForEdit", userDTO);
            model.addAttribute("allSectors", getSectorList());
        }
        findAllUsers(model);
        return "users";
    }

    @PostMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute(value="userDTO") UserDTO userDTO
            , RedirectAttributes redirAttrs, Model model){

            Integer result = userService.save(userDTO);
            if (result == null || result < 1) {
                redirAttrs.addFlashAttribute("error", "User don't saved,some problem occurred. please try again");
                return "redirect:/";
            }
            redirAttrs.addFlashAttribute("success", "user "+userDTO != null && userDTO.getId() != null && userDTO.getId().intValue() > 0 ? "edited":"saved"+" successfully.");

        if(userDTO != null && userDTO.getId() != null && userDTO.getId().intValue() > 0){
            findAllUsers(model);
            model.addAttribute("userForEdit", null);
            model.addAttribute("allSectors", null);
            return "users";
        }else{
            return "redirect:/";
        }

    }


    private void findAllUsers(Model model){
        List<UserDTO> userDTOList = userService.findAllUsers();
        Map<Integer, SectorDTO> map = sectorService.getMapSectorDTOs();
        model.addAttribute("allUsers", userDTOList);
        model.addAttribute("sectorMap", map);
    }


}
