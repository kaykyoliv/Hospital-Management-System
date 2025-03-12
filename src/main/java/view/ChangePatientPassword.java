package view;

import controller.UpdatePatientPassword;
import model.Database;
import model.Option;
import model.Patient;
import model.User;

import java.util.Scanner;

public class ChangePatientPassword implements Option {
    @Override
    public void operation(Scanner sc, Database database, User user) {
        String oldPassword;
        do {
            System.out.println("Enter old password: ");
            oldPassword = sc.next();
        } while (!oldPassword.equals(user.getPassword()));

        String newPassword;
        String confirmPassword;

        System.out.println("Enter new password: ");
        newPassword = sc.next();

        do {
            System.out.println("Confirm password: ");
            confirmPassword = sc.next();
        } while (!confirmPassword.equals(newPassword));

        user.setPassword(newPassword);

        if(new UpdatePatientPassword((Patient) user, database).isUpdated()){
            System.out.println("Password changed successfully");
        }
    }

    @Override
    public String getName() {
        return "Change Password";
    }
}
