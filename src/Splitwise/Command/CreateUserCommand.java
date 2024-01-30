package Splitwise.Command;

import Splitwise.Controllers.UserController;
import Splitwise.Dtos.CreateUserRequestDto;

public class CreateUserCommand implements Command{
    public static String command="create";
    private UserController userController;

    public CreateUserCommand(UserController userController) {
        this.userController = userController;
    }

    @Override
    public boolean ismatch(String input) {
        String[] in=input.split(" ");
        return command.equals(in[0]);
    }

    @Override
    public void execute(String input) {
        String[] in=input.split(" ");
        CreateUserRequestDto createUserRequestDto=new CreateUserRequestDto();
        createUserRequestDto.setName(in[1]);
        createUserRequestDto.setPhone(in[2]);
        createUserRequestDto.setMail(in[3]);
        createUserRequestDto.setPassword(in[4]);
        userController.createUser(createUserRequestDto);
    }
}
