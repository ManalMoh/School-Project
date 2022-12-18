package com.example.project1;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Data @AllArgsConstructor
public class Teacher {
    @NotNull(message = "ID must be filled!")
   // @Pattern(regexp="^(0|[1-9][0-9]*)$", message = "ID must be number!")
    //@Min(6)
    //@Max(10)
    private int ID;
    @NotEmpty(message = "Name must be filled!")
    @Size(min =4, max=10, message = "name should be more than 4 less than 10 letters")
    private String name;
    @NotNull(message = "Salary must be filled!")
   // @Pattern(regexp="^(0|[1-9][0-9]*)$", message = "Age must be number!")
    private Integer salary;
    }
