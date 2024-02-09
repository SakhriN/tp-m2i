package org.yourcompany.infra.orm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.yourcompany.domain.models.Expense;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private double amount;

    private String establishment;

    public Expense toExpense() {
        return new Expense.Builder().title(title).amount(amount).id(id).establishment(establishment).build();
    }
}
