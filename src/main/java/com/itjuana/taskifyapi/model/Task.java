package com.itjuana.taskifyapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {
    @Id
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
