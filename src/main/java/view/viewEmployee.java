package view;


import controller.ReadEmployee;
import model.Database;
import model.Employee;
import model.Option;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class viewEmployee implements Option {
    @Override
    public void operation(Scanner sc, Database database, User user) {
        ArrayList<Employee> employees = new ReadEmployee(database).getEmployees();

        for(Employee e : employees){
            System.out.println("ID:\t\t" + e.getID());
            System.out.println("Name:\t\t" + e.getFirstName());
            System.out.println("Email:\t\t" + e.getEmail());
            System.out.println("Phone number:\t\t" + e.getPhoneNumber());
            System.out.println("Salary:\t\t" + e.getSalary());
            System.out.println("---------------------------------------");
        }

    }

    @Override
    public String getName() {
        return "View All Employees";
    }
}
