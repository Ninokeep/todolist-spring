package com.todolist.todolist.users;

import org.springframework.beans.factory.annotation.Autowired;

public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
}
