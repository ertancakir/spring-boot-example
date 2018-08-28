package com.controller;

import com.service.AddressService;
import com.service.OrderService;
import com.service.UserService;
import com.service.dto.AddressDTO;
import com.service.dto.OrderDTO;
import com.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AddressService addressService;

    @Autowired
    OrderService orderService;


    @RequestMapping(value = "/index", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getAllUser(){
        List<UserDTO> users = userService.findAll();
        if(users == null) return ResponseEntity.status(201).body("<h1>Kullanıcı Bulunamadı</h1>");
        return ResponseEntity.status(200).body(users);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity addUser(@RequestBody UserDTO userDTO){
        userService.save(userDTO);
        return ResponseEntity.status(201).body("<h1>Kullanıcı Eklendi</h1>");
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getUserById(@PathVariable("id") Long id){
        UserDTO userDTO = userService.findById(id);
        if(userDTO == null) return ResponseEntity.status(500).body(userDTO);
        return ResponseEntity.status(200).body(userDTO);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = "text/html")
    public ResponseEntity deleteUser(@PathVariable("id") Long id){
        if(userService.deleteUser(id)){
            UserDTO deletedUser = userService.findById(id);
            return ResponseEntity.status(200).body("<h1> "+ deletedUser.getUserFirstName() + " Kullanıcısı Silindi </h1>");
        }
        return ResponseEntity.status(500).body("<h1> Böyle bir kullanıcı bulunamadı </h1>");
    }

    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getAddressesByUser(@PathVariable("id") Long id){
        List<AddressDTO> addresses = addressService.findAddressByUserID(id);
        return ResponseEntity.status(200).body(addresses);
    }

    @RequestMapping(value = "/address/index",method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getAllAddresses(){
        List<AddressDTO> addressDTOS = addressService.findAll();
        return ResponseEntity.status(200).body(addressDTOS);
    }

    @RequestMapping(value = "/address/add", method = RequestMethod.POST, consumes = "application/json", produces = "text/html")
    public ResponseEntity addAddressToUser(@RequestBody AddressDTO addressDTO){
        addressService.save(addressDTO);
        UserDTO userDTO = userService.findById(addressDTO.getUserID());
        return ResponseEntity.status(201).body("<h1>Adres " + userDTO.getUserFirstName() + " kullanıcısına eklendi</h1>");
    }
}
