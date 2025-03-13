package view;

import controller.ReadPatient;
import controller.ReadPatientOperations;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewPatientOperations implements Option {
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
        ArrayList<Operation> operations = new ReadPatientOperations(patient, database).getOperations();

        System.out.println("---------------------------------------");
        for(Operation o : operations){
            System.out.println("ID:\t\t\t\t" + o.getID());
            System.out.println("Doctor:\t\t\t" + o.getDoctor().getName());
            System.out.println("Patient:\t\t" + o.getPatient().getName());
            System.out.println("Date Time:\t\t" + o.getDateTime());
            System.out.println("Paid:\t\t\t" + o.isPaid());
            System.out.println("Diagnosis:\t\t" + o.getDiagnosis());
            System.out.println("---------------------------------------");
        }

    }

    @Override
    public String getName() {
        return "View Patient's Operations";
    }
}
