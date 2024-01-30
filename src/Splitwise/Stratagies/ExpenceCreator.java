package Splitwise.Stratagies;

import Splitwise.Models.Expense;
import Splitwise.Models.User;
import Splitwise.Models.UserExpense;

import java.util.List;

public interface ExpenceCreator {
    List<UserExpense> createExpense(List<User> users, List<Integer> values, Expense expense);
}
