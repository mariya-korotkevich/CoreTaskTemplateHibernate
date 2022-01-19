package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Маша", "Иванова", (byte) 18);
        userService.saveUser("Даша", "Петрова", (byte) 6);
        userService.saveUser("Петя", "Смирнов", (byte) 28);
        userService.saveUser("Вася", "Баранов", (byte) 15);
        List<User> list = userService.getAllUsers();
        for (User user : list) {
            System.out.println(user);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}