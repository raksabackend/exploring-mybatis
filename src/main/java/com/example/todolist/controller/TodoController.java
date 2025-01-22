package com.example.todolist.controller;

import com.example.todolist.mapper.TodoMapper;
import com.example.todolist.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {

    private TodoMapper todoMapper;

    @Autowired // Automatically injects the TodoMapper via setter
    public void setTodoMapper(TodoMapper todoMapper) {
        this.todoMapper = todoMapper;
    }

    @GetMapping("/list")
    public String listTodos(Model model) {
        List<Todo> todos = todoMapper.findAll();
        model.addAttribute("todos", todos);
        return "home";
    }

    @PostMapping
    public String addTodo(@ModelAttribute Todo todo){
        todoMapper.insert(todo);
        System.out.println(todo.getDescription());
        return "home";
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable int id){
        todoMapper.delete((long) id);
        System.out.println("Task has been deleted");
        return "home";
    }

}
