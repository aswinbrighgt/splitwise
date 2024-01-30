package Splitwise.Command;

public interface Command {
    boolean ismatch(String input);
    void execute(String input);
}
