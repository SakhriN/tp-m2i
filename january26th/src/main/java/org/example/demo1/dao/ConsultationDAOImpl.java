package org.example.demo1.dao;

import org.example.demo1.models.Consultation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class ConsultationDAOImpl extends DAOService implements ConsultationDAO {

    Transaction tx = null;

    public ConsultationDAOImpl() {
        registre = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
    }

    public void Create(Consultation consultation) {
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(consultation);
        tx.commit();
        session.close();
    }


    public Consultation ReadOne(int id) {
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Consultation consultation = session.get(Consultation.class, id);
        tx.commit();
        session.close();
        return consultation;
    }

    public List<Consultation> ReadAll() {
        Session session = sessionFactory.openSession();
        Query<Consultation> query = session.createQuery("FROM Consultation");
        List<Consultation> consultations = query.list();
        session.close();
        return consultations;
    }

    public List<Consultation> ReadById(int id){
        Session session = sessionFactory.openSession();
        Query<Consultation> query = session.createQuery("FROM Consultation WHERE id_pa = :id ");
        query.setParameter("id",id);
        List<Consultation> consultations = query.list();
        session.close();
        return consultations;
    }

    public void Update(Consultation consultation) {
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();

        session.update(consultation);
        tx.commit();
        session.close();
    }

    public void Delete(int id) {
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Consultation consultation = session.get(Consultation.class, id);
        session.delete(consultation);
        tx.commit();
        session.close();
    }

}
