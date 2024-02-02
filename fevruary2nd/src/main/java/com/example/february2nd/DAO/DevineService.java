package com.example.february2nd.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DevineService {

        protected StandardServiceRegistry registre;

        protected SessionFactory sessionFactory;

        protected Session session;

        public DevineService() {
            registre = new StandardServiceRegistryBuilder().configure().build();
            sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();

        }
}
