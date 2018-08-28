package com.repository;

import com.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unused")
public interface UserRepository extends CrudRepository <User, Long> {
    User findUserByUserID(Long id);
}
