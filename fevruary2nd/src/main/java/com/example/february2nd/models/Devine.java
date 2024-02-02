package com.example.february2nd.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Devine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String devine_text, answer;

    public Devine(String devine_text, String answer) {
        this.devine_text = devine_text;
        this.answer = answer;
    }
}
