package com.splitwise2.expense;

import com.splitwise2.User;
import com.splitwise2.split.Split;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public abstract class Expense {

    private int id;

    private double amount;

    private String paidBy;

    private List<Split> splits;

    public Expense(int id, double amount, String paidBy, List<Split> splits) {
        this.id = id;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
    }

    public abstract void validate();

}
