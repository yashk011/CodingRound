package org.example.designPattern.SplitWise.controller;

import org.example.designPattern.SplitWise.model.Group;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GroupController {
    List<Group> groupList;

    public GroupController() {
        groupList = new ArrayList<>();
    }

    public String addGroup(String groupName) {
        String id = UUID.randomUUID().toString();
        Group group = new Group(groupName, id);
        groupList.add(group);
        return id;
    }

    public Group getGroup(String groupId) {
        for(Group group : groupList) {
            if(group.getGroupId().equals(groupId))
                return group;
        }
        return null;
    }
}
