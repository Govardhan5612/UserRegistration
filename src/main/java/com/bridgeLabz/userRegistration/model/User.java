package com.bridgeLabz.userRegistration.model;

import com.bridgeLabz.userRegistration.dto.UserDto;
import com.bridgeLabz.userRegistration.dto.UserLogin;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "UserTable")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String password;
    public User(UserDto dto){
        name=dto.getName();
        phoneNumber=dto.getPhoneNumber();
        email=dto.getEmail();
        password=dto.getPassword();
    }
    public User(UserLogin dto){
        email=dto.getEmail();
        password=dto.getPassword();
    }
}
