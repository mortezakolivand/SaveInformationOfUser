package com.mk.testAssignment.servic;

import com.mk.testAssignment.dto.UserDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    @Transactional(rollbackFor = Exception.class)
    Integer save(UserDTO userDTO);
    @Transactional(readOnly = true)
    List<UserDTO> findAllUsers();
    @Transactional(readOnly = true)
    UserDTO findById(Integer id);
}
