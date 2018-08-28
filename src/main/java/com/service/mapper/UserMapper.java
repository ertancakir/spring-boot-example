package com.service.mapper;

import com.domain.User;
import com.service.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserMapper implements EntityMapper<UserDTO, User> {

    public User toEntity(UserDTO dto) {
        User user = new User();
        user.setUserEmail(dto.getUserEmail());
        user.setUserFirstName(dto.getUserFirstName());
        user.setUserLastName(dto.getUserLastName());
        user.setUserPassword(dto.getUserPassword());
        return user;
    }

    public UserDTO toDto(User entity) {
        UserDTO dto = new UserDTO(entity.getUserID(),entity.getUserEmail(),entity.getUserPassword(),entity.getUserFirstName(),entity.getUserLastName());
        return dto;
    }

    public List<User> toEntity(List<UserDTO> dtoList) {
        List<User> entityList = new ArrayList<User>();
        for(UserDTO userDTO : dtoList){
            entityList.add(toEntity(userDTO));
        }
        return entityList;
    }

    public List<UserDTO> toDto(List<User> entityList) {
        List<UserDTO> dtoList = new ArrayList<UserDTO>();
        for(User user : entityList){
            dtoList.add(toDto(user));
        }
        return dtoList;
    }
}
