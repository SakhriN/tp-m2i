package org.yourcompany.infra.orm.repository;

import org.yourcompany.infra.orm.entity.ExpenseEntity;

import java.util.List;

public class ExpenseEntityRepository extends Repository<ExpenseEntity>  {
    @Override
    public ExpenseEntity findById(int id) {
        return session.get(ExpenseEntity.class, id);
    }

    public List<ExpenseEntity> findAllByKey(String key) {
        return (session
                .createQuery("from ExpenseEntity where title like :q", ExpenseEntity.class)
                .setParameter("q", key+"%"))
                .list();
    }

    @Override
    List<ExpenseEntity> findAll() {
        return null;
    }
}

