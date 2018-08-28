package com.service.impl;


import com.domain.Address;
import com.domain.User;
import com.repository.AddressRepository;
import com.repository.UserRepository;
import com.service.AddressService;
import com.service.dto.AddressDTO;
import com.service.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserRepository userRepository;

    public void save(AddressDTO addressDTO) {
        AddressMapper mapper = new AddressMapper();
        Address address = mapper.toEntity(addressDTO);
        User user = userRepository.findUserByUserID(addressDTO.getUserID());
        address.setUser(user);
        addressRepository.save(address);
    }

    public List<AddressDTO> findAll() {
        if(userRepository.count() == 0) return null;
        AddressMapper mapper = new AddressMapper();
        List<AddressDTO> addressDTOS = new ArrayList<AddressDTO>();
        Iterable<Address> addresses = addressRepository.findAll();
        for(Address a : addresses){
            addressDTOS.add(mapper.toDto(a));
        }
        return addressDTOS;
    }

    public AddressDTO findById(Long id) {
        return null;
    }

    public List<AddressDTO> findAddressByUserID(Long userId) {
        AddressMapper mapper = new AddressMapper();
        if(!userRepository.existsById(userId)) return null;
        User user = userRepository.findUserByUserID(userId);
        List<Address> addresses = addressRepository.getAddressesByUser(user);
        List<AddressDTO> addressDTOS = mapper.toDto(addresses);
        return addressDTOS;
    }
}
