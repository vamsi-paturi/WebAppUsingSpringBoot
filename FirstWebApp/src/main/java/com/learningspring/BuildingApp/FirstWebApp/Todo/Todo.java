package com.learningspring.BuildingApp.FirstWebApp.Todo;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class Todo {


    public Todo( int id, String username, String description, LocalDate target, boolean done) {
        super();
        this.id = id;
        this.username = username;
        this.description = description;
        this.target = target;
        this.done = done;
    }


    private int id;
    private String username;

    @Size(min = 5,max = 51)
    private String description;
    private LocalDate target;
    private boolean done;


    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getTarget() {
        return target;
    }

    public boolean isDone() {
        return done;
    }




    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTarget(LocalDate target) {
        this.target = target;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", target=" + target +
                ", done=" + done +
                '}';
    }





}
