package com.example.ex2.repo;

import com.example.ex2.entity.TVSerie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TVSerieRepository extends CrudRepository<TVSerie,Integer> {
    public List<TVSerie> findAllByGenre(String genre);

    public List<TVSerie> findAllByStatus(Boolean status);
}
