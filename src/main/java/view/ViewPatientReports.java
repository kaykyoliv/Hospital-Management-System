package view;

import controller.ReadPatient;
import controller.ReadPatientReport;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewPatientReports implements Option {
    @Override
    public void operation(Scanner sc, Database database, User user) {
        System.out.println("Enter patient id (-1 to show all patients): ");
        int id = sc.nextInt();
        while(id == -1){
            new ViewAllPatients().operation(sc, database, user);
            System.out.println("Enter patient id (-1 to show all patients): ");
            id = sc.nextInt();
        }

        ArrayList<Report> reports = new ReadPatientReport(new ReadPatient(id, database).getPatient(), database).getReports();

        System.out.println("---------------------------------------");
        for(Report r : reports){
            System.out.println("ID:\t\t\t\t" + r.getID());
            System.out.println("Doctor:\t\t\t" + r.getDoctor().getName());
            System.out.println("Patient:\t\t" + r.getPatient().getName());
            System.out.println("Date Time:\t\t" + r.getDateTime());
            System.out.println("Paid:\t\t\t" + r.isPaid());
            System.out.println("Diagnosis:\t\t" + r.getDiagnosis());
            System.out.println("Treatment:\t\t" + r.getTreatment());
            System.out.println("---------------------------------------");
        }
    }

    @Override
    public String getName() {
        return "View Patient's Report";
    }
}
