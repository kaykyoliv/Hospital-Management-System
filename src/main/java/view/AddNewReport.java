package view;

import controller.CreateOperation;
import controller.CreateReport;
import controller.ReadPatient;
import model.*;

import java.util.Scanner;

public class AddNewReport implements Option {
    @Override
    public void operation(Scanner sc, Database database, User user) {
        Report report = new Report();
        report.setDoctor((Doctor) user);

        System.out.println("Enter patient id (-1 to show all patients): ");
        int patientId = sc.nextInt();
        while (patientId < 0) {
            new ViewAllPatients().operation(sc, database, user);
            System.out.println("Enter patient id (-1 to show all patients): ");
            patientId = sc.nextInt();
        }

        report.setPatient(new ReadPatient(patientId, database).getPatient());

        System.out.println("Enter Date time with format (" + report.getDateTimeFormatter() + "): ");
        sc.nextLine();
        report.setDateTime(sc.nextLine());

        System.out.println("Enter diagnosis: ");
        report.setDiagnosis(sc.next());

        System.out.println("Enter treatment: ");
        report.setTreatment(sc.next());
        report.setPaid(false);

        System.out.println("\nDoctor:\t\t" + report.getDoctor().getName());
        System.out.println("Patient:\t" + report.getDoctor().getName());
        System.out.println("Date time:\t" + report.getDateTime());
        System.out.println("Diagnosis:\t" + report.getDiagnosis());
        System.out.println("Treatment:\t" + report.getTreatment());
        System.out.println("Paid:\t\t" + report.isPaid());

        System.out.println("Are you sure that you want to continue? \n" +
                "These data cannot be updated later \n" +
                "1. Continue");
        if (sc.nextInt() == 1) {
            if (new CreateReport(report, database).isCreated()) {
                System.out.println("Report created successfully");
            }
        }
    }

    @Override
    public String getName() {
        return "Add New Report";
    }
}
