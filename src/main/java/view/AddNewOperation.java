package view;

import controller.CreateOperation;
import controller.ReadPatient;
import model.*;

import java.util.Scanner;

public class AddNewOperation implements Option {
    @Override
    public void operation(Scanner sc, Database database, User user) {

        Operation operation = new Operation();
        operation.setDoctor((Doctor) user);

        System.out.println("Enter patient id (-1 to show all patients): ");
        int patientId = sc.nextInt();
        while (patientId < 0) {
            new ViewAllPatients().operation(sc, database, user);
            System.out.println("Enter patient id (-1 to show all patients): ");
            patientId = sc.nextInt();
        }

        operation.setPatient(new ReadPatient(patientId, database).getPatient());

        System.out.println("Enter Date time with format (" + operation.getDateTimeFormatter() + "): ");
        sc.nextLine();
        operation.setDateTime(sc.nextLine());
        operation.setPaid(false);
        System.out.println("Enter diagnosis: ");
        operation.setDiagnosis(sc.next());

        System.out.println("\nDoctor:\t\t" + operation.getDoctor().getName());
        System.out.println("Patient:\t" + operation.getDoctor().getName());
        System.out.println("Date time:\t" + operation.getDateTime());
        System.out.println("Paid:\t\t" + operation.isPaid());
        System.out.println("Diagnosis:\t" + operation.getDiagnosis());

        System.out.println("Are you sure that you want to continue? \n" +
                "These data cannot be updated later \n" +
                "1. Continue");
        if (sc.nextInt() == 1) {
            if (new CreateOperation(operation, database).isCreated()) {
                System.out.println("Operation added successfully");
            }
        }

    }

    @Override
    public String getName() {
        return "Add New Operation";
    }
}
