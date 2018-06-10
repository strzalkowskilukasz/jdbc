package controller;

import dao.UserDao;
import model.User;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) throws SQLException {
        Menu menu = new Menu();
        menu.wyswietlMenu();
    }

    public void wyswietlMenu() throws SQLException {
        UserDao userDao = new UserDao();
        Scanner scanner = new Scanner(System.in);
        String chooseOption;

        System.out.println("1- add new user to data base");
        System.out.println("2- delete user from data base");
        System.out.println("3- update user's data");
        System.out.println("4- find user by ID number");
        System.out.println("5- show all users");
        System.out.println("6- quit application");

        do {
        System.out.println("Choose your option: ");
        chooseOption = scanner.next();

            switch (chooseOption) {
                case "1":
                    System.out.print("Enter new user's first name: ");
                    String firstName = scanner.next();
                    System.out.print("Enter new user's last name: ");
                    String lastName = scanner.next();
                    System.out.print("Enter new user's last e-mail: ");
                    String email = scanner.next();

                    userDao.save(new User(firstName, lastName, email));

                    break;
                case "2":
                    System.out.print("Enter ID number of user who you want to delete: ");
                    int id = scanner.nextInt();
                    userDao.delete(id);

                    break;
                case "3":
                    System.out.print("Enter user's ID whose data you want to change: ");
                    id = scanner.nextInt();
                    System.out.print("Enter user's new first name: ");
                    firstName = scanner.next();
                    System.out.print("Enter user's new last name: ");
                    lastName = scanner.next();
                    System.out.print("Enter user's new e-mail: ");
                    email = scanner.next();

                    userDao.update(new User(id, firstName, lastName, email));

                    break;
                case "4":
                    System.out.print("Enter ID number of searching user:  ");
                    id = scanner.nextInt();
                    userDao.findById(id);
                    System.out.println(userDao.findById(id));

                    break;
                case "5":
                    System.out.println("List of all users: ");

                    userDao.findAll();

                    for (User user : userDao.findAll()) {
                        System.out.println(user);
                    }

                    break;
                case "q":
                case "Q":
                    System.out.println("Thank You");
                    System.out.println("@ Lucjan 2018");

                    break;
            }
        } while (!chooseOption.equalsIgnoreCase("Q"));
    }
}
