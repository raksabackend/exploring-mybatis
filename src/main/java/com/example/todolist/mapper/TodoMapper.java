package com.example.todolist.mapper;

import com.example.todolist.model.Todo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {
//    void insert(Todo todo);
//    void update(Todo todo);
//    void delete(Long id);s
//    Todo findById(Long id);
//    @Select("SELECT * FROM todo")
    List<Todo> findAll();
}

