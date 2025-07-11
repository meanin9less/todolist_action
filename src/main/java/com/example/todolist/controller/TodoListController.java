package com.example.todolist.controller;

import com.example.todolist.data.dao.TodoListDAO;
import com.example.todolist.data.dto.TodoListDTO;
import com.example.todolist.data.entity.TodoList;
import com.example.todolist.service.TodoListService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Data
@RequestMapping(value = "/api")
public class TodoListController {
    private final TodoListService todoListService;

    @GetMapping(value = "/todolist")
    public ResponseEntity<List<TodoListDTO>> getAllTodoList() {
        List<TodoListDTO> todos = this.todoListService.getAllTodoLists();
        return ResponseEntity.ok().body(todos);
    }

    @PostMapping(value = "/new-todo")
    public ResponseEntity<TodoListDTO> addTodo(@RequestBody TodoListDTO todoListDTO) {
        return ResponseEntity.ok().body(this.todoListService.addTodoList(todoListDTO));
    }

    @PutMapping(value = "/update-todo")
    public ResponseEntity<TodoListDTO> updateTodo(@RequestBody TodoListDTO todoListDTO) {
        TodoListDTO updateDTO = this.todoListService.updateTodoList(todoListDTO);
        return ResponseEntity.ok().body(updateDTO);
    }

    @DeleteMapping(value = "/delete-todo")
    public void deleteTodo() {
        this.todoListService.deleteAllTodoList();
    }

}
