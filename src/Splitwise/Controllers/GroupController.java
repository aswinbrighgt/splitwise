package Splitwise.Controllers;

import Splitwise.Models.Group;
import Splitwise.Services.GroupServices;

public class GroupController {
    private GroupServices groupServices;

    public GroupController(GroupServices groupServices) {
        this.groupServices = groupServices;
    }
    public void createGroup(String user,String name){
        groupServices.createGroup(user,name);
    }
    public Group getGroup(String name){
        return groupServices.getGroup(name);
    }

    public void addmember(String user,String name) {
        groupServices.addmember(user,name);
    }
}
