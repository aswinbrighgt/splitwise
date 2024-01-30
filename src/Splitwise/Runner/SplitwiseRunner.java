package Splitwise.Runner;

import Splitwise.Command.*;
import Splitwise.Controllers.ExpenceController;
import Splitwise.Controllers.GroupController;
import Splitwise.Controllers.UserController;
import Splitwise.Models.UserExpense;
import Splitwise.Repositories.ExpenceRepository;
import Splitwise.Repositories.GroupRepository;
import Splitwise.Repositories.UserRepository;
import Splitwise.Services.ExpenceServices;
import Splitwise.Services.GroupServices;
import Splitwise.Services.UserServices;

import java.util.List;
import java.util.Scanner;

public class SplitwiseRunner {
    public static void main(String[] args) {
        CommandExecutor commandExecutor=new CommandExecutor();
        UserRepository userRepository=new UserRepository();
        ExpenceRepository expenceRepository=new ExpenceRepository();
        GroupRepository groupRepository=new GroupRepository();
        UserController userController=new UserController(new UserServices(userRepository));
        GroupController groupController=new GroupController(new GroupServices(groupRepository,userRepository));
        ExpenceController expenceController=new ExpenceController
                (new ExpenceServices(expenceRepository,userRepository,groupRepository));
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
        Scanner scn=new Scanner(System.in);
        while(true){
            String input=scn.nextLine();
            if("exit".equals(input)) break;
            commandExecutor.execute(input);
        }
        List<UserExpense> expenses=expenceRepository.getUserExpenses("dinner");
        for(UserExpense userExpense:expenses){
            System.out.println(userExpense.getUser().getName()+" "
                    +userExpense.getAmount());
        }
    }
}
