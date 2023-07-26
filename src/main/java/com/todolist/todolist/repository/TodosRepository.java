package com.todolist.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todolist.todolist.models.Todos;

@Repository
public interface TodosRepository extends JpaRepository<Todos, Long> {

}
