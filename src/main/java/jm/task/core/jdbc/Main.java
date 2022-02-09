package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Маша", "Иванова", (byte) 18);
        userService.saveUser("Даша", "Петрова", (byte) 6);
        userService.saveUser("Петя", "Смирнов", (byte) 28);
        userService.saveUser("Вася", "Баранов", (byte) 15);
        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}