package com.example.todolist.controller;

import com.example.todolist.mapper.TodoMapper;
import com.example.todolist.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // For normal REST API
//@Controller //for thymeleaf mvc
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

    @GetMapping("/{id}")
    public Todo findById(@PathVariable int id){
        if( id <= 0 ) {
            throw new RuntimeException("Invalid Id");
        }
        Todo todo = todoMapper.findById(Long.valueOf(id));
        System.out.println("Here is your todo item.");
        return todo;
    }

    @PostMapping
    public String addTodo(@ModelAttribute Todo todo){
        todoMapper.insert(todo);
        System.out.println(todo.getDescription());
        return "home";
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable int id){
        if( id <= 0 ) {
            throw new RuntimeException("Invalid Id");
        }
        todoMapper.delete((long) id);
        System.out.println("Task has been deleted.");
        return "home";
    }

    @PutMapping("/update/{id}")
    public void update ( @PathVariable Long id, @ModelAttribute Todo updatedTodo){
        if(id == null || id <= 0 ) {
            throw new RuntimeException("Invalid Id");
        }
        todoMapper.update(id,updatedTodo); // Ensure your mapper method is implemented correctly
        System.out.println("Task has been updated.");
    }

}
