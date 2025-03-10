package view;

import model.Database;

import java.util.Scanner;

public class Login {

    public Login(Scanner sc, Database database) {
        System.out.println("Welcome to hospital management system");
        System.out.println("Enter email: ");
        String email = sc.next();
        System.out.println("Enter password: ");
        String password = sc.next();

        controller.Login login = new controller.Login(email, password, database);
        if (login.isLoggedIn()) {
            login.getUser().showList(sc, database);
        } else {
            System.out.println("Wrong email or password");
        }
    }
}
