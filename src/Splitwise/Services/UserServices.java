package Splitwise.Services;

import Splitwise.Dtos.CreateUserRequestDto;
import Splitwise.Dtos.Transaction;
import Splitwise.Models.*;
import Splitwise.Repositories.ExpenceRepository;
import Splitwise.Repositories.GroupRepository;
import Splitwise.Repositories.UserRepository;
import Splitwise.Stratagies.SettleupStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServices {
    private UserRepository userRepository;
    private GroupRepository groupRepository;
    private ExpenceRepository expenceRepository;
    private SettleupStrategy settleupStrategy;

    public UserServices(UserRepository userRepository, GroupRepository groupRepository, ExpenceRepository expenceRepository, SettleupStrategy settleupStrategy) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.expenceRepository = expenceRepository;
        this.settleupStrategy = settleupStrategy;
    }

    public void createUser(CreateUserRequestDto createUserRequestDto){
        User newuser=new User();
        newuser.setName(createUserRequestDto.getName());
        newuser.setMail(createUserRequestDto.getMail());
        newuser.setPhone(createUserRequestDto.getPhone());
        newuser.setPassword(createUserRequestDto.getPassword());
        userRepository.addUser(newuser);
    }
    public User getUserbyName(String name){
        return userRepository.getUserbyName(name);
    }

    public void updatePassword(String name, String password) {
        User update=userRepository.getUserbyName(name);
        update.setPassword(password);
    }

    public List<Transaction> settleupUserGroup(String userName, String groupName) {
        Map<User, Integer> extraAmountMap = new HashMap<>();

        List<Expense> expenses = groupRepository.getGroupbyName(groupName).getExpenses();

        for(Expense expense: expenses){
            if(expense.getExpenseType().equals(ExpenseType.NORMAL)){
                List<UserExpense> userExpenseList =
                        expenceRepository.getUserExpenses(expense);
                for(UserExpense userExpense: userExpenseList){
                    User user = userExpense.getUser();
                    if (!extraAmountMap.containsKey(user)) {
                        extraAmountMap.put(user, 0);
                    }

                    Integer amount = extraAmountMap.get(user);
                    if (userExpense.getUserExpenseType().equals(UserExpenseType.PAID_BY)) {
                        amount += userExpense.getAmount();
                    }
                    else{
                        amount -= userExpense.getAmount();
                    }

                    extraAmountMap.put(user, amount);
                }
            }
        }
        // finding the transactions using extra amount for every user.

        List<Transaction> groupTransactions = settleupStrategy.settleUpUsers(extraAmountMap);

        List<Transaction> userTransactions = new ArrayList<>();

        for(Transaction transaction: groupTransactions){
            if(transaction.getFrom().equals(userName) ||
                    transaction.getTo().equals(userName)){
                userTransactions.add(transaction);
            }
        }

        return userTransactions;
    }

    public List<Transaction> settleupUser(String user) {
            return null;
    }
}