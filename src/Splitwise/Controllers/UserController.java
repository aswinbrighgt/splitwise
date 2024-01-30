package Splitwise.Controllers;

import Splitwise.Dtos.CreateUserRequestDto;
import Splitwise.Models.User;
import Splitwise.Services.UserServices;

public class UserController {
    private UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    public void createUser(CreateUserRequestDto createUserRequestDto){
        userServices.createUser(createUserRequestDto);
    }
    public User getUserbyName(String name){
        return userServices.getUserbyName(name);
    }

    public void updatePassword(String name, String password) {
        userServices.updatePassword(name,password);
    }
}
