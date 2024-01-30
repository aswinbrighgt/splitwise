package Splitwise.Services;

import Splitwise.Models.Expense;
import Splitwise.Models.Group;
import Splitwise.Models.User;
import Splitwise.Models.UserExpense;
import Splitwise.Repositories.ExpenceRepository;
import Splitwise.Repositories.GroupRepository;
import Splitwise.Repositories.UserRepository;
import Splitwise.Stratagies.ExpenceCreator;
import Splitwise.Stratagies.ExpenseCreatorFactory;

import java.util.ArrayList;
import java.util.List;

public class ExpenceServices {
    private ExpenceRepository expenceRepository;
    private UserRepository userRepository;
    private GroupRepository groupRepository;

    public ExpenceServices(ExpenceRepository expenceRepository, UserRepository userRepository, GroupRepository groupRepository) {
        this.expenceRepository = expenceRepository;
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }

    public void createExpense(String input) {
       String[] in=input.split(" ");
       int length=in.length-1;
       String Description="";
       while(!in[length].equals("Desc")){
           Description=in[length]+Description;
           length--;
       }
        Expense expense=new Expense();
       expense.setDescription(Description);
        Group group = groupRepository.getGroupbyName(in[2]);
        List<User> users=new ArrayList<>();
        int pointer=2;
        if(group==null){
            users.add(userRepository.getUserbyName(in[0]));
            while(userRepository.getUserbyName(in[pointer])!=null){
                users.add(userRepository.getUserbyName(in[pointer]));
                pointer++;
            }
        }
        else{
            users=group.getUsers();
        }
        if(pointer==2) pointer++;
        ExpenceCreator expenceCreator= ExpenseCreatorFactory.create(in[pointer]);
        pointer++;
        int amount=0;
        List<Integer> values=new ArrayList<>();
        while(!in[pointer].equals("Exact") && !in[pointer].equals("Equal")
                && !in[pointer].equals("Ratio") && !in[pointer].equals("Percent")){
            int val=Integer.parseInt(in[pointer]);
            amount+=val;
            values.add(val);
            pointer++;
        }
        expense.setAmount(amount);
        List<UserExpense> userExpenses=expenceCreator.createExpense(users,values,expense);
        for(UserExpense userExpense:userExpenses){
            expenceRepository.adduserExpenses(userExpense);
        }
        expenceRepository.addexpenses(expense);
    }
}
