package com.example.ex2.controller;

import com.example.ex2.entity.TVSerie;
import com.example.ex2.repo.TVSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tvseries")
public class TVSerieRestController {

    @Autowired
    private TVSerieRepository tvSerieRepository;

    @GetMapping
    public Iterable<TVSerie> getAllTVSerie() {
        return tvSerieRepository.findAll();
    }

    @GetMapping("/{id}")
    public TVSerie getTVSerieById(@PathVariable int id) {
        return tvSerieRepository.findById(id).orElse(null);
    }

    @PostMapping
    public TVSerie createTVSerie(@RequestBody TVSerie tvSerie) {
        return tvSerieRepository.save(tvSerie);
    }

    @PutMapping("/{id}")
    public TVSerie updateTVSerie(@PathVariable int id, @RequestBody TVSerie updatedTVSerie) {
        if (tvSerieRepository.existsById(id)) {
            updatedTVSerie.setId(id);
            return tvSerieRepository.save(updatedTVSerie);
        } else {
            return null; // Handle the case where the user with the given ID doesn't exist
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        tvSerieRepository.deleteById(id);
    }
}
