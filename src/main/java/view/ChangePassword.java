package view;

import controller.UpdateEmployeePassword;
import model.Database;
import model.Option;
import model.User;

import java.util.Scanner;

public class ChangePassword implements Option {
    @Override
    public void operation(Scanner sc, Database database, User user) {
        String oldPassword;
        do {
            System.out.println("Enter old password: ");
            oldPassword = sc.next();
        } while (!oldPassword.equals(user.getPassword()));

        System.out.println("Enter new password: ");
        String newPassword = sc.next();
        String confirmPassword;

        do {
            System.out.println("Confirm password: ");
            confirmPassword = sc.next();
        } while (!newPassword.equals(confirmPassword));
        user.setPassword(newPassword);

        if(new UpdateEmployeePassword(user, database).isUpdated()){

            System.out.println("Password updated successfully");
        }
    }

    @Override
    public String getName() {
        return "Change Password";
    }
}
