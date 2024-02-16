package com.example.february16th.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private UUID id;
    @NotNull
    @Size(min = 3, message = "Si tu met pas minimum 3 caractères, va te faire foutre !!!!")
    private String title;

    @NotNull
    @Size(min = 3, message = "Si tu met pas minimum 3 caractères, va te faire foutre !!!!")
    private String description;


    @NotNull
    private String content;

    private List<Comment> comments;
}
