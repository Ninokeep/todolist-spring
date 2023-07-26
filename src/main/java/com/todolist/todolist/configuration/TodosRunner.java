package com.todolist.todolist.configuration;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.todolist.todolist.models.Todos;
import com.todolist.todolist.repository.TodosRepository;

@Configuration
public class TodosRunner {

    @Bean
    CommandLineRunner commandLineRunner(TodosRepository todosRepository) {
        return args -> {
            Todos task1 = new Todos(1L, "read ebook spring", "read this ebook for tomorrow", false);
            Todos task2 = new Todos(2L, "go run", "go running for saturday", true);
            todosRepository.saveAll(
                    List.of(task1, task2));
        };
    }
}
