package com.cicd.controller;


import com.cicd.dtos.request.UserDto;
import com.cicd.dtos.response.UserResponse;
import com.cicd.model.Users;
import com.cicd.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping("signUp")
    public UserResponse registerUsers(@RequestBody UserDto userDto){
        return userService.registerUsers(userDto);
    }

    @GetMapping("findUserByEmail/{email}")
    public UserResponse findUserByEmail(@PathVariable String email){
        return userService.findUserByEmail(email);
    }

    @GetMapping("findAllUser")
    public List<Users> findAllUsers(){
        return userService.findAllUsers();
    }
}
