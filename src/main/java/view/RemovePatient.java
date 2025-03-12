package view;

import controller.DeletePatient;
import model.Database;
import model.Option;
import model.User;

import java.util.Scanner;

public class RemovePatient implements Option {
    @Override
    public void operation(Scanner sc, Database database, User user) {
        System.out.println("Enter patient id (-1 to show all patients): ");
        int id = sc.nextInt();
        while(id < 0){
            new ViewAllPatients().operation(sc, database, user);
            System.out.println("Enter patient id (-1 to show all patients): ");
             id = sc.nextInt();
        }

        if(new DeletePatient(id, database).isDeleted()){
            System.out.println("Patient deleted successfully");
        }
    }

    @Override
    public String getName() {
        return "Remove Patient";
    }
}
