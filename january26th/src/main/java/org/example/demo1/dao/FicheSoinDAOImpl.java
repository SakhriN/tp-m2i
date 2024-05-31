package org.example.demo1.dao;

import org.example.demo1.models.FicheSoin;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class FicheSoinDAOImpl extends DAOService implements FicheSoinDAO {

    Transaction tx = null;

    public FicheSoinDAOImpl() {
        registre = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
    }

    public void Create(FicheSoin ficheSoin) {
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(ficheSoin);
        tx.commit();
        session.close();
    }

    ;

    public FicheSoin ReadOne(int id) {
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();
        FicheSoin ficheSoin = session.get(FicheSoin.class, id);
        tx.commit();
        session.close();
        return ficheSoin;
    }

    public List<FicheSoin> ReadAll() {
        Session session = sessionFactory.openSession();
        Query<FicheSoin> query = session.createQuery("FROM FicheSoin");
        List<FicheSoin> ficheSoins = query.list();
        session.close();
        return ficheSoins;
    }

    public List<FicheSoin> ReadById(int id){
        Session session = sessionFactory.openSession();
        Query<FicheSoin> query = session.createQuery("FROM FicheSoin WHERE id_co_fi = :id ");
        query.setParameter("id",id);
        List<FicheSoin> fichesSoin = query.list();
        session.close();
        return fichesSoin;
    }

    public void Update(FicheSoin ficheSoin) {
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();

        session.update(ficheSoin);
        tx.commit();
        session.close();
    }

    public void Delete(int id) {
        Session session = sessionFactory.openSession();
        tx = session.beginTransaction();
        FicheSoin ficheSoin = session.get(FicheSoin.class, id);
        session.delete(ficheSoin);
        tx.commit();
        session.close();
    }

}
