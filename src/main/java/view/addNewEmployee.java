package view;

import model.*;

import java.util.Scanner;

public class addNewEmployee implements Option {

    @Override
    public void Operation(Scanner sc, Database database, User user) {
        System.out.println("Enter first name: ");
        String firstName = sc.next();
        System.out.println("Enter last name: ");
        String lastName = sc.next();
        System.out.println("Enter email: ");
        String email = sc.next();
        System.out.println("Enter phone number: ");
        String phoneNumber = sc.next();

        System.out.println("Enter password: ");
        String password = sc.next();
        String confirmPassword;
        do{
            System.out.println("Confirm password: ");
            confirmPassword  = sc.next();
        } while(!password.equals(confirmPassword));

        System.out.println("Enter salary: ");
        double salary = sc.nextDouble();

        int job;
        do{
            System.out.println("Enter job title: \n1. Cashier, \n2. Receptionist");
            job = sc.nextInt();
        } while(job < 0 || job > 2);

        Employee employee;

        switch (job){
            case 1:
                employee = new Cashier();
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setEmail(email);
                employee.setPhoneNumber(phoneNumber);
                employee.setPassword(password);
                break;
            case 2:
                employee = new Receptionist();
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setEmail(email);
                employee.setPhoneNumber(phoneNumber);
                employee.setPassword(password);
            break;
        }
    }

    @Override
    public String getName() {
        return "Add New Employee";
    }
}
