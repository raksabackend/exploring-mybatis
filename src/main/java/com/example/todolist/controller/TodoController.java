package com.example.todolist.controller;

import com.example.todolist.mapper.TodoMapper;
import com.example.todolist.model.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {

    private final TodoMapper todoMapper;

    public TodoController(TodoMapper todoMapper) {
        this.todoMapper = todoMapper;
    }

    @GetMapping("/list")
    public String listTodos(Model model) {
        List<Todo> todos = todoMapper.findAll();
        model.addAttribute("todos", todos);
        return "todo/list";
    }

//    @PostMapping
//    public String addTodo(@ModelAttribute Todo todo){
//        todoMapper.insert(todo);
//        System.out.println(todo.getDescription());
//        return "todo/list";
//    }

}
