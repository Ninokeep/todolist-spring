package com.todolist.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todolist.todolist.models.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}
