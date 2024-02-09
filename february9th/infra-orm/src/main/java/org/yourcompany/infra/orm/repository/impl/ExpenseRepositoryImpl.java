package org.yourcompany.infra.orm.repository.impl;

import org.yourcompany.domain.models.Expense;
import org.yourcompany.domain.repository.ExpenseRepository;
import org.yourcompany.infra.orm.entity.ExpenseEntity;
import org.yourcompany.infra.orm.repository.ExpenseEntityRepository;
import org.yourcompany.infra.orm.util.HibernateSession;
import org.hibernate.Session;

import java.util.List;
import java.util.stream.Collectors;

public class ExpenseRepositoryImpl implements ExpenseRepository {

    private final ExpenseEntityRepository expenseEntityRepository;

    public ExpenseRepositoryImpl(ExpenseEntityRepository expenseEntityRepository) {
        this.expenseEntityRepository = expenseEntityRepository;
    }

    @Override
    public void create(Expense expense) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        try (session) {
            expenseEntityRepository.setSession(session);
            ExpenseEntity expenseEntity = ExpenseEntity.builder()
                    .title(expense.getTitle())
                    .amount(expense.getAmount())
                    .establishment(expense.getEstablishment())
                    .build();
            expenseEntityRepository.create(expenseEntity);
            expense.setId(expense.getId());
            session.getTransaction().commit();
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;
        }
    }

    @Override
    public void delete(Expense expense) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        try (session) {
            expenseEntityRepository.setSession(session);
            ExpenseEntity expenseEntity = expenseEntityRepository.findById(expense.getId());
            expenseEntityRepository.delete(expenseEntity);
            session.getTransaction().commit();
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;
        }
    }

    @Override
    public Expense findById(int id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        expenseEntityRepository.setSession(session);
        try (session) {
            ExpenseEntity expenseEntity = expenseEntityRepository.findById(id);
            return expenseEntity.toExpense();
        }
    }

    @Override
    public List<Expense> searchExpense(String search) {
        Session session = HibernateSession.getSessionFactory().openSession();
        expenseEntityRepository.setSession(session);
        try (session) {
            return expenseEntityRepository.findAllByKey(search)
                    .stream()
                    .map(expenseEntity -> expenseEntity.toExpense())
                    .collect(Collectors.toList());
        }
    }
}

