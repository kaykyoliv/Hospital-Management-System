package view;


import controller.ReadEmployees;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class viewEmployee implements Option {
    @Override
    public void operation(Scanner sc, Database database, User user) {
        ArrayList<Employee> employees = new ReadEmployees(database).getEmployees();

        for(Employee e : employees){
            System.out.println("ID:\t\t\t\t" + e.getID());
            System.out.println("Name:\t\t\t" + e.getFirstName() + " " + e.getLastName());
            System.out.println("Email:\t\t\t" + e.getEmail());
            System.out.println("Phone number:\t" + e.getPhoneNumber());
            System.out.println("Salary:\t\t\t" + e.getSalary() + " $");
            System.out.println("Job:\t\t\t" + e.getJobToString());
            if(e.getJob() == 0){
                System.out.println("Specialization: " + ((Doctor)e).getSpecialization());
            }
            System.out.println("---------------------------------------");
        }

    }

    @Override
    public String getName() {
        return "View All Employees";
    }
}
