package com.service.mapper;

import com.domain.Address;
import com.service.UserService;
import com.service.dto.AddressDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AddressMapper implements EntityMapper <AddressDTO, Address> {

    @Autowired
    UserService userService;

    public Address toEntity(AddressDTO dto) {
        Address address = new Address();

        address.setCity(dto.getCity());
        address.setDistrict(dto.getDistrict());
        address.setFullAddress(dto.getFullAddress());
        address.setPhoneNumber(dto.getPhoneNumber());
        address.setZipCode(dto.getZipCode());

        return address;
    }

    public AddressDTO toDto(Address entity) {
        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setAddressID(entity.getAddressID());
        addressDTO.setCity(entity.getCity());
        addressDTO.setDistrict(entity.getDistrict());
        addressDTO.setFullAddress(entity.getFullAddress());
        addressDTO.setZipCode(entity.getZipCode());
        addressDTO.setPhoneNumber(entity.getPhoneNumber());

        addressDTO.setUserID(entity.getUser().getUserID());

        return addressDTO;
    }

    public List<Address> toEntity(List<AddressDTO> dtoList) {
        List<Address> entityList = new ArrayList<Address>();
        for(AddressDTO addressDTO : dtoList){
            entityList.add(toEntity(addressDTO));
        }
        return entityList;
    }

    public List<AddressDTO> toDto(List<Address> entityList) {
        List<AddressDTO> dtoList = new ArrayList<AddressDTO>();
        for(Address address : entityList){
            dtoList.add(toDto(address));
        }
        return dtoList;
    }
}
