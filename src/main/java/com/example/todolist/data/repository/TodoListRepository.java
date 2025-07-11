package com.example.todolist.data.repository;

import com.example.todolist.data.entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Integer> {
    @Modifying
    @Query("DELETE FROM TodoList e WHERE e.status = true")
    void deleteByStatus(@Param("status") String status);
}
