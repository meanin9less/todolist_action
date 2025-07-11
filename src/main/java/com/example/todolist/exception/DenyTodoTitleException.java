package com.example.todolist.exception;

public class DenyTodoTitleException extends RuntimeException {
    public DenyTodoTitleException(String message) {
        super(message);
    }
}
