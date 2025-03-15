package view;

import controller.ReadCashierReceipt;
import controller.ReadPatient;
import controller.ReadPatientReceipts;
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
            System.out.println("-------------------------------");
        }
    }

    @Override
    public String getName() {
        return "View Patient's Receipts";
    }
}
