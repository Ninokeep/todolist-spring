package com.todolist.todolist.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.todolist.todolist.models.Todos;
import com.todolist.todolist.repository.TodosRepository;

@Service
public class TodosService {

    private final TodosRepository todosRepository;

    @Autowired
    public TodosService(TodosRepository todosRepository) {
        this.todosRepository = todosRepository;
    }

    public List<Todos> getTodos() {

        return todosRepository.findAll();
    }

    public Optional<Todos> getTodo(Long id) {

        return todosRepository.findById(id);
    }

    public Todos createTodo(Todos todos) {

        if (todos.getName() == null || todos.getTitle() == null) {

            return null;
        }
        todos.setCreateAt();
        if (todos.getFinished() == null) {
            todos.setFinished(false);
        }
        todosRepository.save(todos);
        return todos;
    }

    public Todos updateTodo(Todos todos, Long id) {

        return todosRepository.findById(id).map(
                todo -> {
                    if (todos.getName() != null) {
                        todo.setName(todos.getName());
                    }
                    if (todos.getTitle() != null) {
                        todo.setTitle(todos.getTitle());
                    }
                    if (todos.getFinished() != null) {
                        todo.setFinished(todos.getFinished());

                    }
                    return todosRepository.save(todo);
                }).orElseGet(() -> {
                    return todosRepository.save(todos);
                });
    }

    public Todos deleteTodo(Long id) {
        Optional<Todos> todoFound = todosRepository.findById(id);
        if (!todoFound.isPresent()) {
            new NoSuchElementException("Objet non trouvé avec l'ID : " + id);
        }
        Todos todo = todoFound.get();
        todosRepository.deleteById(todo.getId());
        return todo;
    }
}
