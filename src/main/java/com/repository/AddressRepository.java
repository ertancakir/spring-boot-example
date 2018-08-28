package com.repository;

import com.domain.Address;
import com.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository <Address, Long> {

    Address findAddressByAddressID(Long id);

    List<Address> getAddressesByUser(User user);

}
