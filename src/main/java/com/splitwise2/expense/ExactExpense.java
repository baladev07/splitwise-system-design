package com.splitwise2.expense;

import com.splitwise2.User;
import com.splitwise2.split.Split;

import java.util.List;

public class ExactExpense extends Expense {
    public ExactExpense(int id, double amount, String paidBy, List<Split> splits) {
        super(id, amount, paidBy, splits);
    }

    @Override
    public void validate() {
        System.out.print("hello");

    }
}
