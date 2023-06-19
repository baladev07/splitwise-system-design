package com.splitwise2;

import com.splitwise2.split.EqualSplit;
import com.splitwise2.split.ExactSplit;
import com.splitwise2.split.Split;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Splitwise2Application {

	public static void main(String[] args) {

		SpringApplication.run(Splitwise2Application.class, args);


		ExpenseManager expenseManager = new ExpenseManager();
		expenseManager.addUser(new User("user1","u1","user1@gmail.com",1234567890));
		expenseManager.addUser(new User("user2","u2","user2@gmail.com",1234567890));
		expenseManager.addUser(new User("user3","u3","user3@gmail.com",1234567890));
		expenseManager.addUser(new User("user4","u4","user4@gmail.com",1234567890));

		Scanner scanner = new Scanner(System.in);

		while (true)
		{
			System.out.println("Enter the command:");
			String command = scanner.nextLine();
			String[] commands = command.split(" ");
			String commandType =  commands[0];
			switch (commandType)
			{
				case "SHOW":
					expenseManager.showAllExpense();
					break;
				case "EXPENSE":
					double amount = Double.parseDouble(commands[2]);
					int splitUserCount = Integer.parseInt(commands[3]);
					String expenseType = commands[4+splitUserCount];
					List<Split> splitList = new ArrayList();
					String paidBy = commands[1];
					switch(expenseType)
					{
						case "EXACT":
							for(int i=0;i<splitUserCount;i++)
							{
								double exactAmount = Double.parseDouble(commands[5+splitUserCount+i]);
								splitList.add(new ExactSplit(expenseManager.userMap.get(commands[4+i]),exactAmount));
							}
							expenseManager.addExpense(ExpenseType.Exact,amount,paidBy,splitList);
							break;
						case "EQUAL":
							for(int i=0;i<splitUserCount;i++)
							{
								splitList.add(new EqualSplit(expenseManager.userMap.get(commands[4+i])));
							}
							expenseManager.addExpense(ExpenseType.Equal,amount,paidBy,splitList);
							break;
					}
					break;
			}
		}

	}

}
