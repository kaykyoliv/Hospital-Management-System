package view;

import controller.CreatePatient;
import model.Database;
import model.Option;
import model.Patient;
import model.User;

import java.util.Scanner;

public class AddNewPatient implements Option {
    @Override
    public void operation(Scanner sc, Database database, User user) {
        Patient patient = new Patient();
        System.out.println("Enter first name: ");
        patient.setFirstName(sc.next());
        System.out.println("Enter last name: ");
        patient.setLastName(sc.next());
        System.out.println("Enter email: ");
        patient.setEmail(sc.next());
        System.out.println("Enter phone number: ");
        patient.setPhoneNumber(sc.next());
        System.out.println("Enter password: ");
        String password = sc.next();
        String confirmPassword;
        do {
            System.out.println("Confirm password: ");
            confirmPassword = sc.next();
        } while (!password.equals(confirmPassword));
        patient.setPassword(password);

        System.out.println("Enter blood group: ");
        patient.setBloodGroup(sc.next());

        if(new CreatePatient(patient, database).isCreated()){
            System.out.println("Patient added successfully");
        }
    }

    @Override
    public String getName() {
        return "Add new Patient";
    }
}
