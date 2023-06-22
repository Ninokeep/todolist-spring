package com.todolist.todolist.todos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<String> getTodos() {

        return List.of("un");
    }

}
