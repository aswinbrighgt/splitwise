package Splitwise.Command;

import Splitwise.Controllers.ExpenceController;

public class ExpenceCommand implements Command{
    public static String expence_command="Expence";
    private ExpenceController expenceController;

    public ExpenceCommand(ExpenceController expenceController) {
        this.expenceController = expenceController;
    }

    @Override
    public boolean ismatch(String input) {
        String[] in=input.split(" ");
        return expence_command.equals(in[1]);
    }

    @Override
    public void execute(String input) {
        expenceController.createExpense(input);
    }
}
