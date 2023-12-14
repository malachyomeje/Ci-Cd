package com.cicd.service;

import com.cicd.dtos.request.UpdateDto;
import com.cicd.dtos.request.UserDto;
import com.cicd.dtos.response.UserResponse;
import com.cicd.model.Users;

import java.util.List;

public interface UserService {
    UserResponse registerUsers (UserDto userDto);

    UserResponse findUserByEmail(String email);

    List<Users> findAllUsers();

    UserResponse updateUser (UpdateDto updateDto);

    UserResponse deleteUser(String email);
}
