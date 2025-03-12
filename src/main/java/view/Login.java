package view;

import controller.EmployeeLogin;
import controller.PatientLogin;
import model.Database;

import java.util.Scanner;

public class Login {

    public Login(Scanner sc, Database database) {
        System.out.println("Welcome to hospital management system");
        System.out.println("Enter email: ");
        String email = sc.next();
        System.out.println("Enter password: ");
        String password = sc.next();

        EmployeeLogin login = new EmployeeLogin(email, password, database);
        PatientLogin patientLogin = new PatientLogin(email, password, database);
        if (login.isLoggedIn()) {
            login.getUser().showList(sc, database);
        } else if (patientLogin.isLoggedIn()){
            patientLogin.getPatient().showList(sc, database);
        } else{
            System.out.println("Wrong email or password");
        }
    }
}
