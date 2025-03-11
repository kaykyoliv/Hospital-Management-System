package view;

import controller.ReadEmployees;
import controller.ReadPatients;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewAllPatients implements Option {


    @Override
    public void operation(Scanner sc, Database database, User user) {
        ArrayList<Patient> patients = new ReadPatients(database).getPatients();

        System.out.println("---------------------------------------");
        for (Patient p : patients) {
            System.out.println("ID:\t\t\t\t" + p.getID());
            System.out.println("Name:\t\t\t" + p.getFirstName() + " " + p.getLastName());
            System.out.println("Email:\t\t\t" + p.getEmail());
            System.out.println("Phone number:\t" + p.getPhoneNumber());
            System.out.println("Blood Group:\t" + p.getBloodGroup());
            System.out.println("---------------------------------------");
        }

    }

    @Override
    public String getName() {
        return "View All Patients";
    }
}
