package org.example.demo1.dao;

import org.example.demo1.models.FicheSoin;

import java.util.List;

public interface FicheSoinDAO {
    public void Create(FicheSoin ficheSoin);

    public FicheSoin ReadOne(int id);

    public List<FicheSoin> ReadAll();

    public void Update(FicheSoin ficheSoin);

    public void Delete(int id);
}
