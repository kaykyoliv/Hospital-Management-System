package view;

import controller.CreateEmployee;
import model.*;

import java.util.Scanner;

public class addNewEmployee implements Option {

    @Override
    public void operation(Scanner sc, Database database, User user) {
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
            System.out.println("Enter job title: \n0. Doctor, \n1. Cashier, \n2. Receptionist");
            job = sc.nextInt();
        } while(job < 0 || job > 2);

        String specialization = "";
        if(job == 0){
            System.out.println("Enter specialization");
            specialization = sc.next();
        }

        Employee employee;

        switch (job){
            case 0:
                employee = new Doctor();
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setEmail(email);
                employee.setPhoneNumber(phoneNumber);
                employee.setPassword(password);
                employee.setSalary(salary);
                ((Doctor) employee).setSpecialization(specialization);
                break;
            case 1:
                employee = new Cashier();
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setEmail(email);
                employee.setPhoneNumber(phoneNumber);
                employee.setPassword(password);
                employee.setSalary(salary);
                break;
            case 2:
                employee = new Receptionist();
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setEmail(email);
                employee.setPhoneNumber(phoneNumber);
                employee.setPassword(password);
                employee.setSalary(salary);
            break;
            default:
                employee = new Employee() {
                    @Override
                    public void showList(Scanner sc, Database database) {
                        System.out.println("Unknown job!");
                    }

                    @Override
                    public String getJobToString() {
                        return "Unknown job!";
                    }

                    @Override
                    public int getJob() {
                        return -1;
                    }
                };
        }

        if(new CreateEmployee(employee, database).isCreated()){
            System.out.println("Employee add successfully");
        }
    }

    @Override
    public String getName() {
        return "Add New Employee";
    }
}
