package com.example.todolist.service;

import com.example.todolist.model.UserEntity;
import com.example.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity findUserById(int id) {
        Optional<UserEntity> optionalUser = userRepository.findById((long) id);
        return optionalUser.orElse(null);
    }

}
