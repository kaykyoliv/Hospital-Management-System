package hospital;

import model.Database;
import view.Login;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Login(new Scanner(System.in), new Database());
    }
}
