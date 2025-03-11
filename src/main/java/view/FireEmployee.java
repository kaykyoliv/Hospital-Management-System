package view;

import controller.DeleteEmployee;
import model.Database;
import model.Option;
import model.User;

import java.util.Scanner;

public class FireEmployee implements Option {
    @Override
    public void operation(Scanner sc, Database database, User user) {
        System.out.println("Enter Employee ID (-1 to show all employees): ");
        int id = sc.nextInt();
        while (id < 0) {
            new viewEmployee().operation(sc, database, user);
            System.out.println("Enter Employee ID (-1 to show all employees): ");
            id = sc.nextInt();
        }

        if (new DeleteEmployee(id, database).isDeleted()) {
            System.out.println("Employee deleted successfully");
        }
    }

    @Override
    public String getName() {
        return "Fire Employee";
    }
}
