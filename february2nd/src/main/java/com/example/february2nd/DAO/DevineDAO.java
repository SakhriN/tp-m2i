package com.example.february2nd.DAO;

import com.example.february2nd.models.Devine;

import java.util.List;

public interface DevineDAO {

    public void create(Devine o);
    public Devine ReadById(int id);
    public List<Devine> ReadAll();
    public boolean update(Devine o);
    public boolean delete(Devine o);
}
