package model;

import java.util.Scanner;

public class User {

    private int ID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    protected Option[] options;

    public User() {
    }

    public User(int ID, String firstName, String lastName, String email, String phoneNumber, String password) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void showList(Scanner sc, Database database) {
        for (int i = 1; i <= options.length; i++) {
            System.out.println(i + ". " + options[i - 1].getName());
        }
        int select = sc.nextInt();
        options[select - 1].operation(sc, database, this);
        showList(sc, database);
    }

    public String getName(){
        return firstName + " " + lastName;
    }
}
