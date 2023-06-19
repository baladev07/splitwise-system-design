package com.splitwise2;

import com.splitwise2.expense.EqualExpense;
import com.splitwise2.expense.ExactExpense;
import com.splitwise2.expense.Expense;
import com.splitwise2.split.Split;

import java.util.List;

public class ExpenseService {

    public static int expenseId = 1;

    public static Expense createExpense(ExpenseType expenseType,double amount, String paidBy, List<Split> splits)
    {
        switch (expenseType) {
            case Equal:
                double splitAmount = amount/splits.size();
                for(Split split: splits)
                {
                   split.setAmount(splitAmount);
                }
                return new EqualExpense(expenseId++,amount,paidBy,splits);
            case Exact:
                return new ExactExpense(expenseId++,amount,paidBy,splits);
            default:
                return null;
        }
    }
}
