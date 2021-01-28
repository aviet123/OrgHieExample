package com.example.demo.service.impl;

import com.example.demo.model.Team;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        Optional<User> oldTeam = userRepository.findById(id);
        oldTeam.ifPresent(value -> {
            value.setName(user.getName());
            userRepository.save(oldTeam.get());
        });
        return null;
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class})
    public boolean remove(Long id) {
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
