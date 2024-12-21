package com.itjuana.taskifyapi.model;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Task {
    @NotNull
    private int id;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private String status;
}
