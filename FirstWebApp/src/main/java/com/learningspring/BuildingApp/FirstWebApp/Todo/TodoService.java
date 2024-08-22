package com.learningspring.BuildingApp.FirstWebApp.Todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount,  "Vamsi", "Get AWS Certified 1",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount,"Vamsi", "Learn DevOps 1",
                LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todosCount,"Vamsi", "Learn Full Stack Development 1",
                LocalDate.now().plusYears(3), false));
    }

    public Object updateTodo;

    public List<Todo> findByUsername(String username) {
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String desciption, LocalDate target, boolean done){
    Todo todo = new Todo(++todosCount, username,desciption,target,done);
    todos.add(todo);
    }

    public void deleteByID(int id){
        //todo.getId() == id
        //todo -> todo.getId() == id
        Predicate<? super Todo> predicate = todo -> todo.getId() == id; // Functional Programming Saying if the Id is  equal to
        todos.removeIf(predicate);
    }

//    public void updateByID(int id ){
//        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
//        todos.add(new Todo(id,"in28minutes", "",
//                LocalDate.now().plusYears(3), false));
//    }

    public Todo findById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }


    public void updateTodo(@Valid Todo todo) {
        deleteByID(todo.getId());
        todos.add(todo);
    }
}