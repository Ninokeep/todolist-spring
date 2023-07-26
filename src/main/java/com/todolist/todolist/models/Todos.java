package com.todolist.todolist.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * Todos
 */

@Entity
@Table(name = "todos")
public class Todos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todo_sequence")
    @SequenceGenerator(name = "todo_sequence", sequenceName = "todo_sequence", allocationSize = 1)
    private Long id;

    private String name;

    private LocalDate create_at;

    private Boolean finished;

    private String title;

    public Todos() {
    }

    public Todos(Long id, String name, String title, Boolean finished) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.finished = false;
        this.create_at = LocalDate.now();
    }

    public void setCreateAt() {
        this.create_at = LocalDate.now();
    }

    public Long getId() {

        return this.id;
    }

    public String getName() {

        return this.name;
    }

    public Boolean getFinished() {

        return this.finished;
    }

    public String getTitle() {

        return title;
    }

    public LocalDate getCreateAt() {

        return this.create_at;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
