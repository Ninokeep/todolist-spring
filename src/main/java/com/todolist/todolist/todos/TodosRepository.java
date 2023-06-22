package com.todolist.todolist.todos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodosRepository extends JpaRepository<Todos, Long> {

}
