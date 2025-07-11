package com.example.todolist.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoListDTO {
    private Integer id;
    private String task;
    private boolean status;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
}
