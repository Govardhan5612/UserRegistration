package com.bridgeLabz.userRegistration.service;

import com.bridgeLabz.userRegistration.dto.UserDto;
import com.bridgeLabz.userRegistration.exception.UserException;
import com.bridgeLabz.userRegistration.model.User;
import com.bridgeLabz.userRegistration.repository.UserRepo;
import com.bridgeLabz.userRegistration.util.JWT_Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    JWT_Token jwtToken;
    public String addUser(UserDto dto){
        Optional<User> user = userRepo.findEmail(dto.getEmail());
        if (user.isEmpty()){
            User newUser = new User(dto);
            userRepo.save(newUser);
            return jwtToken.createToken(newUser.getId());
        }
        else {
            return "This email Id already present";
        }
    }
    public Object loginPage(String email,String password){
        Optional<User> user=userRepo.loginPage(email,password);
        if (user.isEmpty()){
            return "Invalid Details";
        }
        else {
            return user;
        }
    }
    public List<User> getAll(){
        return userRepo.findAll();
    }
    public User getById(String token){
        int id = jwtToken.decode(token);
        return userRepo.findById(id).orElseThrow(()->new UserException(id+" not found details"));
    }
    public User update(String token,UserDto dto){
        int id = jwtToken.decode(token);
        Optional<User> user = userRepo.findById(id);
        if (user.isEmpty()){
            return userRepo.findById(id).orElseThrow(()->new UserException(id+" not found User"));
        }
        else {
            user.get().setName(dto.getName());
            user.get().setPhoneNumber(dto.getPhoneNumber());
            user.get().setEmail(dto.getEmail());
            user.get().setPassword(dto.getPassword());
            return userRepo.save(user.get());
        }
    }
    public void delete(String token){
        int id = jwtToken.decode(token);
         userRepo.deleteById(id);
    }

    public static void main(String[] args) {
        User u = new User();
        System.out.println(u);
    }
}
