package org.example.demo1.dao;

import org.example.demo1.models.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import java.util.List;

public class PatientDAOImpl implements PatientDAO {

    StandardServiceRegistry registry ;
    SessionFactory sessionFactory;
    Transaction tx = null;

    public PatientDAOImpl() {
        registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public void Create(Patient patient) {
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(patient);
        tx.commit();
        session.close();
    }

    ;

    public Patient ReadOne(int id) {
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Patient patient = session.get(Patient.class, id);
        tx.commit();
        session.close();
        return patient;
    }

    public List<Patient> ReadAll() {
        Session session = sessionFactory.openSession();
        Query<Patient> query = session.createQuery("FROM Patient");
        List<Patient> patients = query.list();
        session.close();
        return patients;
    }

    public void Update(Patient patient) {
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();

        session.update(patient);
        tx.commit();
        session.close();
    }

    public void Delete(int id) {
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Patient patient = session.get(Patient.class, id);
        session.delete(patient);
        tx.commit();
        session.close();
    }

}
