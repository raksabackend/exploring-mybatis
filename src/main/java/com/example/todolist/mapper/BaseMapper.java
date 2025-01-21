package com.example.todolist.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseMapper<T> {
    void insert(T entity);
    void update(T entity);
    void delete(@Param("id") Long id);
    T findById(@Param("id") Long id);

    List<T> findAll();
}


