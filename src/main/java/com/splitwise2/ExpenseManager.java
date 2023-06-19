package com.splitwise2;

import com.splitwise2.expense.Expense;
import com.splitwise2.split.Split;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {


    Map<String,User>userMap;

    List<Expense>expenseList;

    Map<String,Map<String,Double>> balanceSheet;

    ExpenseManager()
    {
         userMap = new HashMap<>();
         expenseList = new ArrayList<>();
         balanceSheet = new HashMap<>();

    }



    public void addUser(User user)
    {
         userMap.put(user.getUserId(),user);
         balanceSheet.put(user.getUserId(), new HashMap<>());
    }

    public void addExpense(ExpenseType expenseType,double amount,String paidBy,List<Split>splits)
    {
        Expense expense  = ExpenseService.createExpense(expenseType,amount,paidBy,splits);
        expenseList.add(expense);
        for(Split split:splits)
        {
            Map<String,Double>spentMap = balanceSheet.get(paidBy);
            String paidTo = split.getUser().getUserId();
            spentMap.put(paidTo,split.getAmount()+spentMap.getOrDefault(paidTo,0.0));
            spentMap.put(paidBy,spentMap.getOrDefault(paidBy,0.0) - split.getAmount());
        }
        System.out.println("Expense added successfully.");
    }

//    public void showExpense()
//    {
//
//    }

    public void showAllExpense()
    {
        boolean isEmpty = true;
        for(Map.Entry<String, Map<String, Double>> allBalance:balanceSheet.entrySet())
        {
            for (Map.Entry< String,Double> userBalance:allBalance.getValue().entrySet()) {
                if(userBalance.getValue()>0)
                {
                    isEmpty = false;
                    printExpense(allBalance.getKey(),userBalance.getKey(),userBalance.getValue().doubleValue());
                }
            }
        }
        if(isEmpty)
        {
            System.out.println("no balance");
        }
    }

    public void printExpense(String paidBy,String paidTo,double amount)
    {
         System.out.println(paidTo+" owes "+paidBy+":"+amount);
    }

}
