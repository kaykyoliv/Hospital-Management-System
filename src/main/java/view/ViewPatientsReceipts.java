package view;

import controller.*;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewPatientsReceipts implements Option {

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

        ArrayList<Receipt> receipts = new ReadPatientReceipts(patient, database).getReceipts();
        System.out.println("-------------------------------");
        for(Receipt r : receipts){
            System.out.println("Id: \t\t" + r.getID());
            System.out.println("Cashier: \t" + r.getCashier().getName());
            System.out.println("Patient: \t" + r.getPatient().getName());
            System.out.println("Type: \t\t" + r.getTypeToString());
            System.out.println("Amount: \t" + r.getAmount());
            System.out.println("Item id: \t" + r.getTypeID());

            System.out.println("======== " + r.getTypeID() + " ========");
            if(r.getType() == 0){
                Operation o = new ReadOperation(r.getTypeID(), database).getOperation();
                System.out.println("Doctor:\t\t\t" + o.getDoctor().getName());
                System.out.println("Patient:\t\t" + o.getPatient().getName());
                System.out.println("Date Time:\t\t" + o.getDateTime());
                System.out.println("Paid:\t\t\t" + o.isPaid());
                System.out.println("Diagnosis:\t\t" + o.getDiagnosis());
            } else if (r.getTypeID() == 1){
                Report report = new ReadReport(r.getTypeID(), database).getReport();
                System.out.println("ID:\t\t\t\t" + report.getID());
                System.out.println("Doctor:\t\t\t" + report.getDoctor().getName());
                System.out.println("Patient:\t\t" + report.getPatient().getName());
                System.out.println("Date Time:\t\t" + report.getDateTime());
                System.out.println("Paid:\t\t\t" + report.isPaid());
                System.out.println("Diagnosis:\t\t" + report.getDiagnosis());
                System.out.println("Treatment:\t\t" + report.getTreatment());
            }
            System.out.println("-------------------------------");
        }
    }

    @Override
    public String getName() {
        return "View Patient's Receipts";
    }
}
