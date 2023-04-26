package com.joshuapark.springboot.todolist.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

// JPA maps this bean to a table in database
@Entity
public class Todo {
    @Id
    @GeneratedValue
    private int id;
    private String username;

    @Size(min=10, message="Enter at least 5 Characters")
    private String description;
    private String targetDate;
    private boolean done;
    public Todo() {};
    public Todo(int id, String username, String description, String targetDate, boolean done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getTargetDate() {
        return targetDate;
    }
    public void setTargetDate(String targetDate) {
        this.targetDate = targetDate;
    }
    public boolean isDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
    @Override
    public String toString() {
        return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
                + targetDate + ", done=" + done + "]";
    }
    
}
