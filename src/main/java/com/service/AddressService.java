package com.service;

import com.service.dto.AddressDTO;

import java.util.List;

@SuppressWarnings("unused")
public interface AddressService {

    void save(AddressDTO addressDTO);

    List<AddressDTO> findAll();

    AddressDTO findById(Long id);

    List<AddressDTO> findAddressByUserID(Long userId);
}
