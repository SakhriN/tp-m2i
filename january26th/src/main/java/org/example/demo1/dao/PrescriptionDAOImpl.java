package org.example.demo1.dao;

import org.example.demo1.models.Prescription;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class PrescriptionDAOImpl extends DAOService implements PrescriptionDAO {

    Transaction tx = null;

    public PrescriptionDAOImpl() {
        registre = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
    }

    public void Create(Prescription prescription) {
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(prescription);
        tx.commit();
        session.close();
    }

    ;

    public Prescription ReadOne(int id) {
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Prescription prescription = session.get(Prescription.class, id);
        tx.commit();
        session.close();
        return prescription;
    }

    public List<Prescription> ReadAll() {
        Session session = sessionFactory.openSession();
        Query<Prescription> query = session.createQuery("FROM Prescription");
        List<Prescription> prescriptions = query.list();
        session.close();
        return prescriptions;
    }

    public List<Prescription> ReadById(int id){
        Session session = sessionFactory.openSession();
        Query<Prescription> query = session.createQuery("FROM Prescription WHERE id_co_pr = :id ");
        query.setParameter("id",id);
        List<Prescription> prescriptions = query.list();
        session.close();
        return prescriptions;
    }

    public void Update(Prescription prescription) {
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();

        session.update(prescription);
        tx.commit();
        session.close();
    }

    public void Delete(int id) {
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Prescription prescription = session.get(Prescription.class, id);
        session.delete(prescription);
        tx.commit();
        session.close();
    }

}
