package view;

import controller.ReadPatient;
import controller.UpdatePatient;
import model.Database;
import model.Option;
import model.Patient;
import model.User;

import java.util.Scanner;

public class EditPatient implements Option {
    @Override
    public void operation(Scanner sc, Database database, User user) {
        System.out.println("Enter patient id (int): \n(-1 to show all patients)");
        int id = sc.nextInt();

        while (id < 0) {
            new ViewAllPatients().operation(sc, database, user);
            System.out.println("Enter patient id (int): \n(-1 to show all patients)");
            id = sc.nextInt();
        }

        Patient p = new ReadPatient(id, database).getPatient();
        System.out.println("Enter first name (-1 to keep old value)");
        String firstName = sc.next();
        if (!firstName.equals("-1")) p.setFirstName(firstName);

        System.out.println("Enter last name (-1 to keep old value)");
        String lastName = sc.next();
        if (!lastName.equals("-1")) p.setLastName(lastName);

        System.out.println("Enter email (-1 to keep old value)");
        String email = sc.next();
        if (!email.equals("-1")) p.setEmail(email);

        System.out.println("Enter phone number (-1 to keep old value)");
        String phoneNumber = sc.next();
        if (!phoneNumber.equals("-1")) p.setPhoneNumber(phoneNumber);

        System.out.println("Enter blood group (-1 to keep old value)");
        String bloodGroup = sc.next();
        if (!bloodGroup.equals("-1")) p.setBloodGroup(bloodGroup);

        if(new UpdatePatient(p, database).isUpdated()){
            System.out.println("Patient updated successfully");
        }
    }

    @Override
    public String getName() {
        return "Edit Patient";
    }
}
