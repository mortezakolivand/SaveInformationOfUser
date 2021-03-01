package com.mk.testAssignment.servic.impl;

import com.mk.testAssignment.domain.User;
import com.mk.testAssignment.dto.UserDTO;
import com.mk.testAssignment.repository.SectorRepository;
import com.mk.testAssignment.repository.UserRepository;
import com.mk.testAssignment.servic.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SectorRepository sectorRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer save(UserDTO userDTO) {
        User user;
        if (userDTO.getId() != null && userDTO.getId() > 0){
            user = userRepository.getOne(userDTO.getId());
        }else {
            user = new User();
        }
        user.setAgreeToTerms(userDTO.getAgreeToTerms() ? Byte.valueOf((byte) 1) : Byte.valueOf((byte) 0));
        user.setName(userDTO.getName());
        user.setSector(sectorRepository.getOne(userDTO.getSectorId()));
        User resultUser = userRepository.save(user);
        return resultUser.getId();
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserDTO> findAllUsers() {
        List<User> userList = userRepository.findAll();
        if (userList != null && userList.size() > 0) {
            List<UserDTO> userDTOList = new ArrayList<>();
            userList.stream().forEach(user -> {
                UserDTO userDTO = new UserDTO();
                BeanUtils.copyProperties(user, userDTO);
                userDTO.setSectorId(user.getSector().getId());
                userDTO.setAgreeToTerms(user.getAgreeToTerms() != null && user.getAgreeToTerms().equals((byte)1));
                userDTOList.add(userDTO);
            });
            return  userDTOList;
        }
        return null;
    }

    @Override
    public UserDTO findById(Integer id) {
        if (id != null && id.intValue() > 0){
            User user = userRepository.getOne(id);
            if (user != null && user.getId() != null){
                UserDTO userDTO = new UserDTO();
                BeanUtils.copyProperties(user, userDTO);
                userDTO.setSectorId(user.getSector().getId());
                userDTO.setAgreeToTerms(user.getAgreeToTerms() != null && user.getAgreeToTerms().equals((byte)1));
                return userDTO;
            }
        }
        return null;
    }
}
