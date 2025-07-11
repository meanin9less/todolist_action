package com.example.todolist.service;

import com.example.todolist.data.dao.TodoListDAO;
import com.example.todolist.data.dto.TodoListDTO;
import com.example.todolist.data.entity.TodoList;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class TodoListService {
    private final TodoListDAO todoListDAO;

    public List<TodoListDTO> getAllTodoLists() {
        List<TodoList> todoLists = this.todoListDAO.findAll();
        List<TodoListDTO> todoListDTOs = new ArrayList<>();
        if (todoLists.isEmpty()) {
            throw new EntityNotFoundException("TodoLists not found");
        }
        for (TodoList todoList : todoLists) {
            todoListDTOs.add(
                    TodoListDTO.builder()
                            .id(todoList.getId())
                            .task(todoList.getTask())
                            .status(todoList.isStatus())
                            .createtime(todoList.getCreatetime())
                            .build());
        }
        return todoListDTOs;
    }

    public TodoListDTO addTodoList(TodoListDTO todoListDTO) {
        TodoList todo = this.todoListDAO.addTodoList(TodoList.builder()
                .task(todoListDTO.getTask())
                .status(false)
                .createtime(LocalDateTime.now())
                .build());

        return TodoListDTO.builder()
                .id(todo.getId())
                .task(todo.getTask())
                .status(todo.isStatus())
                .build();
    }

    public TodoListDTO updateTodoList(TodoListDTO todoListDTO) {
        TodoList todoList = this.todoListDAO.updateTodoList(
                TodoList.builder()
                        .id(todoListDTO.getId())
                        .status(true)
                        .updatetime(LocalDateTime.now())
                        .build()
        );
        if (todoList == null) {
            throw new EntityNotFoundException("TodoLists not found");
        }
        return TodoListDTO.builder()
                .id(todoList.getId())
                .task(todoList.getTask())
                .status(todoList.isStatus())
                .build();
    }

    public void deleteAllTodoList() {
        this.todoListDAO.deleteAllByStatus();
    }
}
