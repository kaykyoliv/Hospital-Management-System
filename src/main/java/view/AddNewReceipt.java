package view;

import controller.CreateReceipt;
import controller.ReadPatient;
import model.*;

import java.util.Scanner;

public class AddNewReceipt implements Option {


    @Override
    public void operation(Scanner sc, Database database, User user) {
        Receipt r = new Receipt();
        r.setCashier((Cashier) user);
        System.out.println("Select type: \n0. Operation \n1. Report");
        r.setType(sc.nextInt());

        System.out.println("Enter patient id (-1 to show all patients): ");
        int patientId = sc.nextInt();
        while (patientId < 0) {
            new ViewAllPatients().operation(sc, database, user);
            System.out.println("Enter patient id (-1 to show all patients): ");
            patientId = sc.nextInt();
        }
        Patient patient = new ReadPatient(patientId, database).getPatient();
        r.setPatient(patient);

        int itemId;
        if (r.getTypeID() == 0) {
            System.out.println("Enter operation id (-1 to show all operations): ");
            itemId = sc.nextInt();
            while (itemId < 0) {
                new ViewPatientUnpaidOperation().operation(sc, database, patient);
                System.out.println("Enter operation id (-1 to show all operations): ");
                itemId = sc.nextInt();
            }
        } else if (r.getTypeID() == 1) {
            System.out.println("Enter report id (-1 to show all reports): ");
            itemId = sc.nextInt();
            while (itemId < 0) {
                new ViewPatientUnpaidReport().operation(sc, database, patient);
                System.out.println("Enter report id (-1 to show all reports): ");
                itemId = sc.nextInt();
            }
        } else {
            System.out.println("Invalid type");
            return;
        }

        r.setTypeID(itemId);

        System.out.println("Enter amount (double): ");
        r.setAmount(sc.nextDouble());

        System.out.println("Are you sure that you want to continue? ");
        System.out.println("Cashier: \t" + r.getCashier().getName());
        System.out.println("Patient: \t" + r.getPatient().getName());
        System.out.println("Type: \t\t" + r.getTypeToString());
        System.out.println("Amount: \t" + r.getAmount());
        System.out.println("Item id: \t" + r.getTypeID());
        System.out.println("These data cannot be edited later\n1. Continue");


        if (sc.nextInt() == 1){
            if (new CreateReceipt(r, database).isCreated()) {
                System.out.println("Receipt paid successfully");
            }
        }
    }

    @Override
    public String getName() {
        return "Add new Receipt";
    }
}
