package com.service;

import com.service.dto.UserDTO;

import java.util.List;

@SuppressWarnings("unused")
public interface UserService {

    UserDTO save(UserDTO userDTO);

    List<UserDTO> findAll();

    UserDTO findById(Long id);

    boolean deleteUser(Long id);
}
