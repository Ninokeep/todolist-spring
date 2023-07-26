package com.todolist.todolist.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.todolist.todolist.repository.UsersRepository;

public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
}
