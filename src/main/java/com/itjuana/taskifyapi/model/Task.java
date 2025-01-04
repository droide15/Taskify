package com.itjuana.taskifyapi.model;

import jakarta.validation.constraints.NotNull;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Scope("prototype")
public class Task {
    @NotNull
    private int id;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private String status;

    @Override
    public String toString() {
        return "Student [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status + "]";
    }
}
