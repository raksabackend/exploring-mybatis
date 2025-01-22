package com.example.todolist.mapper;

import com.example.todolist.model.Todo;

import java.util.List;

public interface TodoMapper {
    void insert(Todo todo);
    void update(Todo todo);
    void delete(Long id);
    Todo findById(Long id);
    List<Todo> findAll();
}

