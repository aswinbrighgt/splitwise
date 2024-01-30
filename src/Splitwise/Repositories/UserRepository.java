package Splitwise.Repositories;

import Splitwise.Models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }
    public void addUser(User user){
        users.add(user);
    }
    public User getUserbyName(String name){
        for(User u:users){
            if(name.equals(u.getName())) return u;
        }
        return null;
    }
}
