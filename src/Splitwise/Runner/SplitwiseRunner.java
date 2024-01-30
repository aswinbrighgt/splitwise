package Splitwise.Runner;

import Splitwise.Command.*;
import Splitwise.Controllers.ExpenceController;
import Splitwise.Controllers.GroupController;
import Splitwise.Controllers.UserController;
import Splitwise.Models.Expense;
import Splitwise.Models.Group;
import Splitwise.Repositories.ExpenceRepository;
import Splitwise.Repositories.GroupRepository;
import Splitwise.Repositories.UserRepository;
import Splitwise.Services.ExpenceServices;
import Splitwise.Services.GroupServices;
import Splitwise.Services.UserServices;
import Splitwise.Stratagies.HeapSettleUpStrategy;

import java.text.MessageFormat;
import java.util.List;
import java.util.Scanner;

public class SplitwiseRunner {
    public static void main(String[] args) {
        CommandExecutor commandExecutor=new CommandExecutor();
        UserRepository userRepository=new UserRepository();
        ExpenceRepository expenceRepository=new ExpenceRepository();
        GroupRepository groupRepository=new GroupRepository();
        HeapSettleUpStrategy heapSettleUpStrategy=new HeapSettleUpStrategy();
        UserController userController=new UserController(
                new UserServices(userRepository,groupRepository,expenceRepository,heapSettleUpStrategy));
        GroupController groupController=new GroupController(new GroupServices(groupRepository,userRepository));
        ExpenceController expenceController=new ExpenceController
                (new ExpenceServices(expenceRepository,userRepository,groupRepository));
        SettleupCommand settleupCommand=new SettleupCommand(userController);
        CreateUserCommand createUserCommand=new CreateUserCommand(userController);
        UpdateUserCommand updateUserCommand=new UpdateUserCommand(userController);
        AddGroupCommand addGroupCommand=new AddGroupCommand(groupController);
        AddMemberCommand addMemberCommand=new AddMemberCommand(groupController);
        ExpenceCommand expenceCommand=new ExpenceCommand(expenceController);
        commandExecutor.add(createUserCommand);
        commandExecutor.add(updateUserCommand);
        commandExecutor.add(addGroupCommand);
        commandExecutor.add(addMemberCommand);
        commandExecutor.add(expenceCommand);
        commandExecutor.add(settleupCommand);
        Scanner scn=new Scanner(System.in);
        while(true){
            String input=scn.nextLine();
            if("exit".equals(input)) break;
            commandExecutor.execute(input);
        }

        Group groups=groupRepository.getGroupbyName("goatrip");
        List<Expense> expenses=groups.getExpenses();
        for(Expense userExpense:expenses){
            System.out.println
                    (MessageFormat.format("{0} {1} {2}", userExpense.getDescription(),
                            userExpense.getAmount(), userExpense.getExpenseType()));
        }
    }
}
