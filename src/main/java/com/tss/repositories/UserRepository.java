package com.tss.repositories;

import com.tss.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
Repository for User Entity
 */
public interface UserRepository extends JpaRepository<User, Integer> {


    List<User> findByStatus(Integer id);

    @Query(value = "select u from User u where u.userName=?1 or u.email=?2")
    User findUserExist(String userName, String email);
}
