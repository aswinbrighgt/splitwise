package Splitwise.Command;

import Splitwise.Controllers.GroupController;

public class AddMemberCommand implements Command{
    public static String addMember_command="AddMember";
    private GroupController groupController;

    public AddMemberCommand(GroupController groupController) {
        this.groupController = groupController;
    }

    @Override
    public boolean ismatch(String input) {
        String[] in=input.split(" ");
        return addMember_command.equals(in[1]);
    }

    @Override
    public void execute(String input) {
        String[] in=input.split(" ");
        groupController.addmember(in[2],in[3]);
    }
}
