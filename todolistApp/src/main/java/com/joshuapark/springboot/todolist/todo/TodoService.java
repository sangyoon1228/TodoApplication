package com.joshuapark.springboot.todolist.todo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;
    static {
        todos.add(new Todo(++todosCount, "joshuapark", "Go Shopping 1", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), false));
        todos.add(new Todo(++todosCount, "joshuapark", "Sweep the Floor 1", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), false));
        todos.add(new Todo(++todosCount, "joshuapark", "Do Homework 1", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), false));
    }

    public List<Todo> findByUsername(String username) {
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, String targetDate, boolean done) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, done);
        todos.add(todo);
    }

    public void deleteTodo(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        return todos.stream().filter(predicate).findFirst().get();
    }

    public void updateTodo(@Valid Todo todo) {
        deleteTodo(todo.getId());
        todos.add(todo);
    }
}
