package Splitwise.Stratagies;

import Splitwise.Models.Expense;
import Splitwise.Models.User;
import Splitwise.Models.UserExpense;
import Splitwise.Models.UserExpenseType;

import java.util.ArrayList;
import java.util.List;

public class multipay implements ExpenceCreator{

    @Override
    public List<UserExpense> createExpense(List<User> users, List<Integer> values, Expense expense) {
        List<UserExpense> userExpenses=new ArrayList<>();
        for(int i=0;i<users.size();i++){
            UserExpense userExpense=new UserExpense();
            userExpense.setExpense(expense);
            userExpense.setUserExpenseType(UserExpenseType.PAID_BY);
            userExpense.setUser(users.get(i));
            userExpense.setAmount(values.get(i));
            userExpenses.add(userExpense);
        }
        return userExpenses;
    }
}
