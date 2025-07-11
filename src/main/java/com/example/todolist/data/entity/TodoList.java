package com.example.todolist.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="todolist")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String task;
    private boolean status;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
}
