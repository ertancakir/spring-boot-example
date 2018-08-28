package com.service.impl;

import com.domain.User;
import com.repository.UserRepository;
import com.service.UserService;
import com.service.dto.UserDTO;
import com.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    public UserDTO save(UserDTO userDTO) {
        UserMapper userMapper = new UserMapper();
        User entity = userMapper.toEntity(userDTO);
        entity = repository.save(entity);
        userDTO = userMapper.toDto(entity);
        return userDTO;
    }

    public List<UserDTO> findAll() {
        long count = repository.count();
        if(count == 0) return null;
        UserMapper userMapper = new UserMapper();
        List<UserDTO> userDTOList = new ArrayList<UserDTO>();
        Iterable<User> users = repository.findAll();

        for(User u : users){
            userDTOList.add(userMapper.toDto(u));
        }
        return userDTOList;
    }

    public UserDTO findById(Long id) {
        if(!repository.existsById(id)) return null;
        UserMapper userMapper = new UserMapper();
        User user = repository.findUserByUserID(id);
        UserDTO userDTO = userMapper.toDto(user);
        return userDTO;
    }

    public boolean deleteUser(Long id){
        if(!repository.existsById(id)) return false;
        User user = repository.findUserByUserID(id);
        repository.delete(user);
        return true;
    }
}
