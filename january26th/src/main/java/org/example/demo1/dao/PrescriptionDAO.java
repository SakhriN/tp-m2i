package org.example.demo1.dao;

import org.example.demo1.models.Prescription;

import java.util.List;

public interface PrescriptionDAO {
    public void Create(Prescription prescription);

    public Prescription ReadOne(int id);

    public List<Prescription> ReadAll();

    public void Update(Prescription prescription);

    public void Delete(int id);

}
