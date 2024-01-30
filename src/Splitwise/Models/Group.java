package Splitwise.Models;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String Name;
    private List<Expense> Expenses;
    private List<User> users;

    public Group(User user,String name) {
        users=new ArrayList<>();
        users.add(user);
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Expense> getExpenses() {
        return Expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        Expenses = expenses;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addmember(User adduser) {
        this.getUsers().add(adduser);
    }
}
