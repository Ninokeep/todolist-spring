package com.todolist.todolist.todos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/todos")
public class TodosController {

    private final TodosService todosService;

    @Autowired
    public TodosController(TodosService todosService) {
        this.todosService = todosService;
    }

    @GetMapping
    public List<Todos> getTodos() {

        return todosService.getTodos();
    }

    @GetMapping("/{id}")
    public Optional<Todos> getTodo(@PathVariable Long id) {

        return todosService.getTodo(id);
    }

    @PostMapping
    public Todos createTodo(@RequestBody Todos todos) {

        return todosService.createTodo(todos);
    }

    @PutMapping("/{id}")
    public Todos updateTodo(@RequestBody Todos todos, @PathVariable Long id) {

        return todosService.updateTodo(todos, id);
    }

    @DeleteMapping("/{id}")
    public Todos deleteTodo(@PathVariable Long id) {

        return todosService.deleteTodo(id);
    }
}
