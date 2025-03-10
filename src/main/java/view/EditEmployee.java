package view;

import controller.ReadEmployee;
import controller.UpdateEmployee;
import model.*;

import java.util.Scanner;

public class EditEmployee implements Option {


    @Override
    public void operation(Scanner sc, Database database, User user) {
        System.out.println("Enter employee id (int): \n(-1 to show all employees)");
        int id = sc.nextInt();

        while (id < 0) {
            new viewEmployee().operation(sc, database, user);
            System.out.println("Enter employee id (int): \n(-1 to show all employees)");
            id = sc.nextInt();
        }

        Employee e = new ReadEmployee(id, database).getEmployee();
        System.out.println("Enter first name (-1 to keep old value)");
        String firstName = sc.next();
        if (!firstName.equals("-1")) e.setFirstName(firstName);

        System.out.println("Enter last name (-1 to keep old value)");
        String lastName = sc.next();
        if (!lastName.equals("-1")) e.setLastName(lastName);

        System.out.println("Enter email (-1 to keep old value)");
        String email = sc.next();
        if (!email.equals("-1")) e.setEmail(email);

        System.out.println("Enter phone number (-1 to keep old value)");
        String phoneNumber = sc.next();
        if (!phoneNumber.equals("-1")) e.setPhoneNumber(phoneNumber);

        System.out.println("Enter salary (-1 to keep old value)");
        double salary = sc.nextDouble();
        if (salary != -1) e.setSalary(salary);

        if (e.getJob() == 0) {
            System.out.println("Enter specialization (-1 to keep old value)");
            String specialization = sc.next();
            if (!specialization.equals("-1"))
                ((Doctor) e).setSpecialization(specialization);
        }

        System.out.println("Enter job (-1 to keep old value)\n0. Doctor, \n1. Cashier, \n2. Receptionist");
        int job = sc.nextInt();

        switch (job){
            case 0:
                System.out.println("Enter specialization");
                String spec = sc.next();
                Doctor d = new Doctor();
                d.setID(e.getID());
                d.setFirstName(e.getFirstName());
                d.setLastName(e.getLastName());
                d.setEmail(e.getEmail());
                d.setPhoneNumber(e.getPhoneNumber());
                d.setPassword(e.getPassword());
                d.setSalary(e.getSalary());
                d.setSpecialization(spec);
                e = d;
                break;
            case 1:
                Cashier c = new Cashier();
                c.setID(e.getID());
                c.setFirstName(e.getFirstName());
                c.setLastName(e.getLastName());
                c.setEmail(e.getEmail());
                c.setPhoneNumber(e.getPhoneNumber());
                c.setPassword(e.getPassword());
                c.setSalary(e.getSalary());
                e = c;
                break;
            case 2:
                Receptionist r = new Receptionist();
                r.setID(e.getID());
                r.setFirstName(e.getFirstName());
                r.setLastName(e.getLastName());
                r.setEmail(e.getEmail());
                r.setPhoneNumber(e.getPhoneNumber());
                r.setPassword(e.getPassword());
                r.setSalary(e.getSalary());
                e = r;
                break;
            case -1:
                break;
            default:
                System.out.println("Invalid job");
                return;
        }


        if (new UpdateEmployee(database, e).isUpdated()) {
            System.out.println("Employee updated successfully");
        }

    }

    @Override
    public String getName() {
        return "Edit Employee";
    }
}
