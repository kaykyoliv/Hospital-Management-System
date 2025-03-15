package view;

import controller.ReadPatientOperations;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewPatientUnpaidOperation implements Option {
    @Override
    public void operation(Scanner sc, Database database, User user) {
        ArrayList<Operation> operations = new ReadPatientOperations((Patient) user, database).getOperations();

        operations.removeIf(Operation::isPaid);
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
        return "View My Unpaind Operations";
    }
}
