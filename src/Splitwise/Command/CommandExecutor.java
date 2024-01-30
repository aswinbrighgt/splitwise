package Splitwise.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {
    private List<Command> commandList;

    public CommandExecutor() {
        this.commandList = new ArrayList<>();
    }

    public void add(Command command) {
        commandList.add(command);
    }

    public void execute(String input) {
        for (Command c : commandList) {
            if (c.ismatch(input)) {
                c.execute(input);
                break;
            }
        }
    }
}
