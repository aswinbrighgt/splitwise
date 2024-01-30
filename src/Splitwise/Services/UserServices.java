package Splitwise.Services;

import Splitwise.Dtos.CreateUserRequestDto;
import Splitwise.Models.User;
import Splitwise.Repositories.UserRepository;

public class UserServices {
    private UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void createUser(CreateUserRequestDto createUserRequestDto){
        User newuser=new User();
        newuser.setName(createUserRequestDto.getName());
        newuser.setMail(createUserRequestDto.getMail());
        newuser.setPhone(createUserRequestDto.getPhone());
        newuser.setPassword(createUserRequestDto.getPassword());
        userRepository.addUser(newuser);
    }
    public User getUserbyName(String name){
        return userRepository.getUserbyName(name);
    }

    public void updatePassword(String name, String password) {
        User update=userRepository.getUserbyName(name);
        update.setPassword(password);
    }
}
