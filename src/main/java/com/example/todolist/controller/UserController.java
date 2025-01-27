package com.example.todolist.controller;

import com.example.todolist.dto.TodoDto;
import com.example.todolist.dto.UserDto;
import com.example.todolist.model.Todo;
import com.example.todolist.model.UserEntity;
import com.example.todolist.repository.UserRepository;
import com.example.todolist.service.TodoService;
import com.example.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoService todoService;

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> findUser() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping("/users")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserDto userDto) {
        UserEntity user = new UserEntity();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword()); // Ensure to hash the password in production!

        UserEntity createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @PostMapping("/users/{userId}/todos")
    public ResponseEntity<Todo> addTodo(@PathVariable int userId, @RequestBody TodoDto todoDto) {
        Todo todo = new Todo();
        todo.setTask(todoDto.getTask());
        todo.setDescription(todoDto.getDescription());

        // Fetch the user entity by ID and set it in the todoobject
        UserEntity user = userService.findUserById(userId); // Implement findById in UserService

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        todo.setUser(user); // Set the associated user in the todoitem
        Todo createdTodo = todoService.createTodo(todo);

        return ResponseEntity.ok(createdTodo);
    }

}

