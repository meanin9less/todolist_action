package com.example.todolist.data.dao;

import com.example.todolist.data.dto.TodoListDTO;
import com.example.todolist.data.entity.TodoList;
import com.example.todolist.data.repository.TodoListRepository;
import jakarta.el.MethodNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoListDAO {
    private final TodoListRepository repository;

    public List<TodoList> findAll() {
        return this.repository.findAll();
    }

    public TodoList addTodoList(TodoList todoList) {
        return this.repository.save(todoList);
    }

    public TodoList updateTodoList(TodoList todoList) {
        Optional<TodoList> optionalTodoList = this.repository.findById(todoList.getId());
        if (!optionalTodoList.isPresent()) {
            throw new MethodNotFoundException("TodoList not found");
        }
        TodoList oldTodoList = optionalTodoList.get();
        oldTodoList.setStatus(todoList.isStatus());
        oldTodoList.setUpdatetime(todoList.getUpdatetime());
        return this.repository.save(oldTodoList);
    }

    @Transactional
    public void deleteAllByStatus() {
        this.repository.deleteByStatus("완료");
    }

}
