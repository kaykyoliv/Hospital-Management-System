package view;

import controller.ReadCashierReceipt;
import controller.ReadOperation;
import controller.ReadPatientReceipts;
import controller.ReadReport;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewUserReceipts implements Option {
    @Override
    public void operation(Scanner sc, Database database, User user) {
        ArrayList<Receipt> receipts = new ReadPatientReceipts((Patient) user, database).getReceipts();
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
        return "View My Receipts";
    }
}
