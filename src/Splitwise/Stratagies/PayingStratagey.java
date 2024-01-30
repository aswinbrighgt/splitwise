package Splitwise.Stratagies;

import Splitwise.Models.User;

import java.util.List;

public interface PayingStratagey {
    void createpaidbyexpense(List<User> users,List<Integer> amount);
}
