package com.bridgeLabz.userRegistration.controller;

import com.bridgeLabz.userRegistration.dto.ResponseDto;
import com.bridgeLabz.userRegistration.dto.UserDto;
import com.bridgeLabz.userRegistration.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("/add")
    public ResponseEntity<ResponseDto> addUser(@Valid @RequestBody UserDto userDto){
        ResponseDto dto = new ResponseDto("Adding User Details Successfully",service.addUser(userDto));
        return new ResponseEntity<ResponseDto>(dto, HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity<ResponseDto> getAll(){
        ResponseDto dto = new ResponseDto("All person details",service.getAll());
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @GetMapping("/login")
    public ResponseEntity<ResponseDto> login(@RequestHeader String email, @RequestHeader String password){
        ResponseDto dto = new ResponseDto("Person Details",service.loginPage(email, password));
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @GetMapping("/getById")
    public ResponseEntity<ResponseDto> update(@RequestHeader String token){
        ResponseDto userDto = new ResponseDto("User details : ",service.getById(token));
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> update(@RequestHeader String token,@Valid@RequestBody UserDto dto){
        ResponseDto userDto = new ResponseDto("Updated User details : ",service.update(token,dto));
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> delete(@RequestHeader String token){
        service.delete(token);
        ResponseDto userDto = new ResponseDto("User details deleted: ","");
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }
}
