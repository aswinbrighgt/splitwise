package Splitwise.Stratagies;

import Splitwise.Models.Expense;
import Splitwise.Models.User;
import Splitwise.Models.UserExpense;
import Splitwise.Models.UserExpenseType;

import java.util.ArrayList;
import java.util.List;

public class singlepay implements ExpenceCreator{

    @Override
    public List<UserExpense> createExpense(List<User> users, List<Integer> values, Expense expense) {
        List<UserExpense> userExpenses=new ArrayList<>();
        UserExpense userExpense=new UserExpense();
        userExpense.setExpense(expense);
        userExpense.setUserExpenseType(UserExpenseType.PAID_BY);
        userExpense.setUser(users.get(0));
        userExpense.setAmount(values.get(0));
        userExpenses.add(userExpense);
        return userExpenses;
    }
}
