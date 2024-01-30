package Splitwise.Repositories;

import Splitwise.Models.Group;


import java.util.ArrayList;
import java.util.List;

public class GroupRepository {
    private List<Group> groups;

    public GroupRepository() {
        this.groups = new ArrayList<>();
    }
    public void addGroup(Group group){
        groups.add(group);
    }
    public Group getGroupbyName(String name){
        for(Group g:groups){
            if(name.equals(g.getName())) return g;
        }
        return null;
    }
}
