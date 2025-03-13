package view;

import controller.ReadPatient;
import model.Database;
import model.Option;
import model.Patient;
import model.User;

import java.util.Scanner;

public class ViewPatientData implements Option {

    @Override
    public void operation(Scanner sc, Database database, User user) {
        System.out.println("Enter patient id (-1 to show all patients): ");
        int id = sc.nextInt();
        while(id == -1){
            new ViewAllPatients().operation(sc, database, user);
            System.out.println("Enter patient id (-1 to show all patients): ");
            id = sc.nextInt();
        }

        Patient patient = new ReadPatient(id, database).getPatient();

        System.out.println("ID:\t\t\t\t" + patient.getID());
        System.out.println("Name:\t\t\t" + patient.getFirstName() + " " + patient.getLastName());
        System.out.println("Email:\t\t\t" + patient.getEmail());
        System.out.println("Phone number:\t" + patient.getPhoneNumber());
        System.out.println("Blood Group:\t" + patient.getBloodGroup());
        System.out.println("---------------------------------------");
    }

    @Override
    public String getName() {
        return "View Patient's Data";
    }
}
