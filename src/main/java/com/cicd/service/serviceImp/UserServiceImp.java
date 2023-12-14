package com.cicd.service.serviceImp;

import com.cicd.dtos.request.UpdateDto;
import com.cicd.dtos.request.UserDto;
import com.cicd.dtos.response.UserResponse;
import com.cicd.model.Users;
import com.cicd.repository.UserRepository;
import com.cicd.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserResponse  registerUsers(UserDto userDto){
        Optional<Users> signUp = userRepository.findByEmail(userDto.getEmail());
        if ( signUp.isPresent()){
            return  new UserResponse("USER NOT FOUND", userDto.getName());
        }
        Users users = Users.builder()
                .name(userDto.getName())
                .age(userDto.getAge())
                .email(userDto.getEmail())
                .build();
        userRepository.save(users);
        return  new UserResponse("REGISTRATION SUCCESSFULLY ", users);
    }


    @Override
    public UserResponse findUserByEmail(String email){

        Optional<Users> users = userRepository.findByEmail(email);
        if ( users.isEmpty()){
            return  new UserResponse("USER NOT FOUND", email);
        }

        Users user = users.get();
        return  new UserResponse("SUCCESS", user);
    }


    @Override
    public List<Users>findAllUsers(){
        return userRepository.findAll();
    }


    @Override
    public  UserResponse updateUser (UpdateDto updateDto){
        Optional<Users> users = userRepository.findById(updateDto.getId());
        if ( users.isEmpty()){
            return  new UserResponse("USER NOT FOUND", updateDto.getEmail());
        }

        Users users1 = users.get();

         users1.setName(updateDto.getName());
        users1.setEmail(updateDto.getEmail());
        users1.setAge(updateDto.getAge());
        userRepository.save(users1);
        return  new UserResponse("UPDATE SUCCESSFULLY", users1);



    }

    @Override
    public UserResponse deleteUser( String email){

        Optional<Users> users = userRepository.findByEmail(email);
        if ( users.isEmpty()){
            return  new UserResponse("USER NOT FOUND", email);
        }
        Users users1 = users.get();

        userRepository.delete(users1);
        return  new UserResponse("USER DELETED SUCCESSFULLY", email);
    }

}
