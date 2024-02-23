package com.example.ex1.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    private UUID id;

    @NotNull
    @Size(min = 3, message = "Si tu met pas minimum 3 caractères, va te faire foutre !!!!")
    String name;

    @NotNull
    int time_preparation;
    @NotNull
    int time_cooking;

    @NotNull
    String instructions;

    @NotNull
    @Size(min = 3, message = "Merci de mettre des ingredients en les séparant par une virgule")
    List<String> ingredients;

}
