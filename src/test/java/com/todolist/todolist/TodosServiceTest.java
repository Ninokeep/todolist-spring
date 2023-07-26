package com.todolist.todolist;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.todolist.todolist.models.Todos;
import com.todolist.todolist.repository.TodosRepository;
import com.todolist.todolist.services.TodosService;

@SpringBootTest
public class TodosServiceTest {

    List<Todos> todosList = new ArrayList<>();

    @Mock
    private TodosRepository todosRepository;

    @InjectMocks
    private TodosService todosService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        Todos todo1 = new Todos(1L, "Todo 1", "Description 1", false);
        Todos todo2 = new Todos(2L, "Todo 2", "Description 2", true);
        this.todosList.add(todo1);
        this.todosList.add(todo2);
    }

    @Test
    public void testGetTodos() {

        when(todosService.getTodos()).thenReturn(todosList);

        List<Todos> result = todosService.getTodos();

        assertEquals(2, result.size());
        assertEquals("Todo 1", result.get(0).getName());
        assertEquals("Todo 2", result.get(1).getName());
    }

    @Test
    public void testGetTodoById() {
        Todos todo = new Todos(1L, "Todo 1", "Description 1", false);
        Optional<Todos> optionalTodo = Optional.of(todo);

        when(todosService.getTodo(1L)).thenReturn(optionalTodo);

        Optional<Todos> result = todosService.getTodo(1L);

        assertTrue(result.isPresent());
        assertEquals("Todo 1", result.get().getName());
    }

    @Test
    public void testCreateTodo() {

        Todos todo = new Todos(null, "New Todo", "New Description", false);

        when(todosRepository.save(any(Todos.class))).thenReturn(todo);

        Todos createdTodo = todosService.createTodo(todo);

        assertNotNull(createdTodo);
        assertEquals("New Todo", createdTodo.getName());
        assertFalse(createdTodo.getFinished());
    }

}
