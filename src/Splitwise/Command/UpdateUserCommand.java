package Splitwise.Command;

import Splitwise.Controllers.UserController;

public class UpdateUserCommand implements Command {
    public static String update_command="update";
    public UserController userController;

    public UpdateUserCommand(UserController userController) {
        this.userController = userController;
    }

    @Override
    public boolean ismatch(String input) {
        String[] in=input.split(" ");
        return update_command.equals(in[0]);
    }

    @Override
    public void execute(String input) {
        String[] in=input.split(" ");
        userController.updatePassword(in[1],in[2]);
    }
}
