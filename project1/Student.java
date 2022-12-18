package com.example.project1;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Student {
    @NotNull(message = "ID must be filled!")
    //@Pattern(regexp="^(0|[1-9][0-9]*)$", message = "ID must be number!") check it later
    //@Min(value =6,message = "ID must be more than 6")
    //@Max(value = 10,message = "ID must be less than 10")
    private Integer Id;
    @NotEmpty(message = "Name must be filled!")
    @Size(min =4, max=10, message = "name should be more than 4 less than 10 letters")
    private String name;
    @NotNull(message="Age must be filled!")
   // @Pattern(regexp="^(0|[1-9][0-9]*)$", message = "Age must be number!")
    //@Min(value = 6, message = "Age must be more than 5")
   // @Max(value = 18,message = "age must be less than 19")
    private int age;
    @NotEmpty(message = "Major must be filled!")
    @Pattern(regexp = "^(CS|Math|Engineer)$", message = "Major should be CS, Math or Engineer!")
    private String major;
}
