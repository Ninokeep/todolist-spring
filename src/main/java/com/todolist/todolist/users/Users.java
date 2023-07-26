package com.todolist.todolist.users;

import com.todolist.todolist.utils.enums.AccountType;
import com.todolist.todolist.utils.enums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.UniqueConstraint;

@Entity(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    private Long id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 255, nullable = false)
    private String firstname;

    @Column(length = 255, unique = true, nullable = false)
    private String email;

    @Column(length = 255, nullable = false)
    private String password;

    @Column()
    private UserRole role;

    @Column()
    private AccountType accountType;

}
