package com.example.todolist.mapper;

import com.example.todolist.model.Todo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TodoMapper {
    void insert(Todo todo);
    void update(@Param("id") Long id, @Param("todo") Todo updatedTodo);
    void delete(Long id);
    Todo findById(Long id);
    List<Todo> findAll();
}

