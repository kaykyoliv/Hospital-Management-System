package view;

import model.Database;
import model.Option;
import model.Patient;
import model.User;

import java.util.Scanner;

public class ViewPatientData implements Option {

    @Override
    public void operation(Scanner sc, Database database, User user) {
        System.out.println("ID:\t\t\t\t" + user.getID());
        System.out.println("Name:\t\t\t" + user.getFirstName() + " " + user.getLastName());
        System.out.println("Email:\t\t\t" + user.getEmail());
        System.out.println("Phone number:\t" + user.getPhoneNumber());
        System.out.println("Blood Group:\t" + ((Patient)user).getBloodGroup());
        System.out.println("---------------------------------------");
    }

    @Override
    public String getName() {
        return "View My Data";
    }
}
