package Splitwise.Stratagies;

import Splitwise.Dtos.Transaction;
import Splitwise.Models.User;

import java.util.List;
import java.util.Map;

public interface SettleupStrategy {
    List<Transaction> settleUpUsers(Map<User,Integer> map);
}
