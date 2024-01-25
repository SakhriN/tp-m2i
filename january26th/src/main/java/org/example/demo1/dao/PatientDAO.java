package org.example.demo1.dao;

import org.example.demo1.models.Patient;

import java.util.List;

public interface PatientDAO {
    public void Create(Patient patient);

    public Patient ReadOne(int id);

    public List<Patient> ReadAll();

    public void Update(Patient patient);

    public void Delete(int id);
}
