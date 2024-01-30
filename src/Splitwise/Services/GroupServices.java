package Splitwise.Services;

import Splitwise.Models.Group;
import Splitwise.Models.User;
import Splitwise.Repositories.GroupRepository;
import Splitwise.Repositories.UserRepository;

public class GroupServices {
    private GroupRepository groupRepository;
    private UserRepository userRepository;

    public GroupServices(GroupRepository groupRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    public void createGroup(String user, String name){
        User user1=userRepository.getUserbyName(user);
        Group group=new Group(user1,name);
        groupRepository.addGroup(group);
    }
    public Group getGroup(String name){
        return groupRepository.getGroupbyName(name);
    }

    public void addmember(String user, String group) {
        User adduser=userRepository.getUserbyName(user);
        Group grouptoadd=groupRepository.getGroupbyName(group);
        grouptoadd.addmember(adduser);
    }
}
