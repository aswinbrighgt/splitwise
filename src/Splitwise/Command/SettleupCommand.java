package Splitwise.Command;

import Splitwise.Controllers.UserController;
import Splitwise.Dtos.Transaction;

import java.text.MessageFormat;
import java.util.List;

public class SettleupCommand implements Command{
    public static String Settleup_Command="SettleUp";
    private UserController userController;

    public SettleupCommand(UserController userController) {
        this.userController = userController;
    }

    @Override
    public boolean ismatch(String input) {
        String[] in=input.split(" ");
        return Settleup_Command.equals(in[1]);
    }

    @Override
    public void execute(String input) {
        String[] in=input.split(" ");
        List<Transaction> transactions;
        if(in.length==2){
            transactions=userController.SettleupUser(in[0]);
        }
        else
            transactions=userController.settleupUserGroup(in[0],in[2]);
        for(Transaction transaction:transactions){
            System.out.println(MessageFormat.format("{0} needs to pay {1} RS to {2}", transaction.getFrom(), transaction.getAmount(), transaction.getTo()));
        }
    }
}
