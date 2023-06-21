package com.bridgeLabz.userRegistration.repository;

import com.bridgeLabz.userRegistration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    @Query(value = "select * from user_table where email =:email", nativeQuery = true)
    Optional<User> findEmail(String email);

    @Query(value = "select * from user_table where email =:email AND password =:password", nativeQuery = true)
    Optional<User> loginPage(String email, String password);
}
