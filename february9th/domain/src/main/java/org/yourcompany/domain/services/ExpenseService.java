package org.yourcompany.domain.services;

import org.yourcompany.domain.models.Expense;
import org.yourcompany.domain.repository.ExpenseRepository;

import java.util.List;

public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense createExpense(String title, double amount, String establishment) {
        //Logique de contrôle
        if(title.length() < 3) {
            throw new RuntimeException("Name length must be gt 3 char");
        }
        //...
        Expense expense = new Expense.Builder().title(title).amount(amount).establishment(establishment).build();
        expenseRepository.create(expense);
        return expense;
    }

    public void deleteExpense(int id) {
        Expense expense = expenseRepository.findById(id);
        if(expense == null) {
            throw new RuntimeException("Expense not found");
        }
        expenseRepository.delete(expense);
    }

    public List<Expense> searchExpense(String search) {
        if(search.length() < 3) {
            throw new RuntimeException("search word length must be gt 3 char");
        }
        List<Expense> list = expenseRepository.searchExpense(search);
        return list;
    }
}
