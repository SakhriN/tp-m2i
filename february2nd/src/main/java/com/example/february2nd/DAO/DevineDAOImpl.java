package com.example.february2nd.DAO;

import com.example.february2nd.models.Devine;
import org.hibernate.query.Query;

import java.util.List;

public class DevineDAOImpl extends DevineService implements DevineDAO {

    @Override
    public void create(Devine o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Devine ReadById(int id) {
        Devine devine = null;
        session = sessionFactory.openSession();
        devine = (Devine) session.get(Devine.class, id);
        session.close();
        return devine;
    }

    @Override
    public List<Devine> ReadAll() {
        List<Devine> devineList = null;
        session = sessionFactory.openSession();
        Query<Devine> devineQuery = session.createQuery("from Devine");
        devineList = devineQuery.list();
        session.close();
        return devineList;
    }

    @Override
    public boolean update(Devine o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Devine o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

}
