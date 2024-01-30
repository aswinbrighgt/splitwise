package Splitwise.Command;

import Splitwise.Controllers.GroupController;

public class AddGroupCommand implements Command{
    public static String addGroup_command="AddGroup";
    private GroupController groupController;

    public AddGroupCommand(GroupController groupController) {
        this.groupController = groupController;
    }

    @Override
    public boolean ismatch(String input) {
        String[] in=input.split(" ");
        return addGroup_command.equals(in[1]);
    }

    @Override
    public void execute(String input) {
        String[] in=input.split(" ");
        groupController.createGroup(in[0],in[2]);
    }
}
