package view;

import controller.ReadPatientReport;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewPatientPaidReports implements Option {

    @Override
    public void operation(Scanner sc, Database database, User user) {
        ArrayList<Report> reports = new ReadPatientReport((Patient) user, database).getReports();

        reports.removeIf(r -> !r.isPaid());
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
        return "View My Paid Reports";
    }
}
