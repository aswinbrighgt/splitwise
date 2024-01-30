package Splitwise.Repositories;

import Splitwise.Models.Expense;
import Splitwise.Models.UserExpense;

import java.util.ArrayList;
import java.util.List;

public class ExpenceRepository {
    List<Expense> expenses;
    List<UserExpense> userExpenses;

    public ExpenceRepository() {
        this.expenses=new ArrayList<>();
        this.userExpenses=new ArrayList<>();
    }

    public List<UserExpense> getUserExpenses(String dinner) {
        List<UserExpense> ret=new ArrayList<>();
        for(UserExpense userExpense:userExpenses){
            if(userExpense.getExpense().getDescription().equals(dinner)){
                ret.add(userExpense);
            }
        }
        return ret;
    }

    public void addexpenses(Expense expense){
        expenses.add(expense);
    }
    public void adduserExpenses(UserExpense userExpense){
        userExpenses.add(userExpense);
    }
    public Expense getExpensebyDesc(String desc){
        for(Expense expense:expenses){
            if(desc.equals(expense.getDescription())) return expense;
        }
        return null;
    }
}
