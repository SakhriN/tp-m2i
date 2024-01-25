package org.example.demo1.dao;

import org.example.demo1.models.Consultation;

import java.util.List;

public interface ConsultationDAO {
    public void Create(Consultation consultation);

    public Consultation ReadOne(int id);

    public List<Consultation> ReadAll();

    public void Update(Consultation consultation);

    public void Delete(int id);
}
