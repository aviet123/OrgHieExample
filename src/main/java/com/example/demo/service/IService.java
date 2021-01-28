package com.example.demo.service;

import com.example.demo.model.User;

public interface IService<T> {
    Iterable<T> findAll();
    T findUserById(Long id);
    T save(T t);
    T update(Long id, T t) throws Exception;
    boolean remove(Long id);
}
