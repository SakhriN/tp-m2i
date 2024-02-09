package org.yourcompany.domain.repository;

import org.yourcompany.domain.models.Expense;

import java.util.List;

public interface ExpenseRepository {
    void create(Expense expense);
    void delete(Expense expense);
    Expense findById(int id);
    List<Expense> searchExpense(String search);
}
