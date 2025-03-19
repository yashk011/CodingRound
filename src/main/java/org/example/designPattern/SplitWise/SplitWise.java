package org.example.designPattern.SplitWise;

import org.example.designPattern.SplitWise.controller.BalanceSheetController;
import org.example.designPattern.SplitWise.controller.GroupController;
import org.example.designPattern.SplitWise.controller.UserController;
import org.example.designPattern.SplitWise.model.*;

import java.util.ArrayList;
import java.util.List;

public class SplitWise {
    UserController userController;
    GroupController groupController;
    BalanceSheetController balanceSheetController;

    public SplitWise() {
        userController = new UserController();
        groupController = new GroupController();
        balanceSheetController = new BalanceSheetController();
    }

    public void demo() {
        setUpUserAndGroup();
    }

    private void setUpUserAndGroup() {
        addUsersToSplitWise();

        User user1 = userController.getUser("U1");
        User user2 = userController.getUser("U2");
        User user3 = userController.getUser("U3");

        String groupId1 = groupController.addGroup("Goa");
        /* Add Members to Group */
        Group group = groupController.getGroup(groupId1);
        group.addMember(user1);
        group.addMember(user2);
        group.addMember(user3);

//        String groupId2 = groupController.addGroup("Room G6");
//        /* Add Members to Group */
//        Group group2 = groupController.getGroup(groupId2);
//        group2.addMember(user1);
//        group2.addMember(user2);


        /* Create Expense within Group */

        ArrayList<Split> splits = new ArrayList<>();
        splits.add(new Split(user1, 100));
        splits.add(new Split(user2, 100));
        splits.add(new Split(user3, 100));

        Expense expense = group.createExpense("1", "Drinks",splits, SplitType.EQUAL, 300, user1 );

        ArrayList<Split> splits2 = new ArrayList<>();
        splits2.add(new Split(user1, 200));
        splits2.add(new Split(user2, 300));

        for(User user : userController.getAllUsers()) {
            System.out.println("Details for User - " + user.getName() + " ");
            balanceSheetController.showBalance(user);
            System.out.println("====================");
        }

        System.out.println("Creating expense 2");
        Expense expense2 = group.createExpense("2", "Breakfast",splits2, SplitType.EQUAL, 500, user2);

        for(User user : userController.getAllUsers()) {
            System.out.println("Details for User - " + user.getName() + " ");
            balanceSheetController.showBalance(user);
            System.out.println("====================");
        }

    }

    public void addUsersToSplitWise() {
        User user1 = new User("U1", "Yash");
        User user2 = new User("U2", "Rudra");
        User user3 = new User("U3", "Aashish");

        userController.addUser(user1);
        userController.addUser(user2);
        userController.addUser(user3);
    }

}
