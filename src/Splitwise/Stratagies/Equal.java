package Splitwise.Stratagies;

import Splitwise.Models.Expense;
import Splitwise.Models.User;
import Splitwise.Models.UserExpense;
import Splitwise.Models.UserExpenseType;

import java.util.ArrayList;
import java.util.List;

public class Equal implements ExpenceCreator{
    @Override
    public List<UserExpense> createExpense(List<User> users, List<Integer> values, Expense expense) {
        int amount=expense.getAmount()/ users.size();
        List<UserExpense> userExpenses=new ArrayList<>();
        for(User user:users){
            UserExpense userExpense=new UserExpense();
            userExpense.setExpense(expense);
            userExpense.setUser(user);
            userExpense.setUserExpenseType(UserExpenseType.HAD_TO_PAY);
            userExpense.setAmount(amount);
            userExpenses.add(userExpense);
        }
        return userExpenses;
    }
}
