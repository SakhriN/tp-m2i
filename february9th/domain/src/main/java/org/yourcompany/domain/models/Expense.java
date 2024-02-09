package org.yourcompany.domain.models;

import java.sql.Date;

public class Expense {
    private int id;
    private String title;
private double amount;
    private String establishment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getEstablishment() {
        return establishment;
    }

    public void setEstablishment(String establishment) {
        this.establishment = establishment;
    }

    private Expense(Builder builder) {
        this.setId(builder.id);
        this.setTitle(builder.title);
        this.setAmount(builder.amount);
        this.setEstablishment(builder.establishment);
    }

    public static class Builder {
        private int id;
        private String title;
        private double amount;
        private String establishment;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder amount(double amount) {
            this.amount = amount;
            return this;
        }
        public Builder establishment(String establishment) {
            this.establishment = establishment;
            return this;
        }

        public Expense build() {
            return new Expense(this);
        }
    }
}

