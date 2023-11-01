package com.phone.repository;

import com.phone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByUserNameAndPassword(String username, String password);
    User findByUserName(String username);

}
