package view;

import controller.ReadAllReceipts;
import model.Database;
import model.Option;
import model.Receipt;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewAllReceipts implements Option {
    @Override
    public void operation(Scanner sc, Database database, User user) {
        ArrayList<Receipt> receipts = new ReadAllReceipts(database).getReceipts();
        System.out.println("-------------------------------");
        for(Receipt r : receipts){
            System.out.println("Id: \t\t" + r.getID());
            System.out.println("Cashier: \t" + r.getCashier().getName());
            System.out.println("Patient: \t" + r.getPatient().getName());
            System.out.println("Type: \t\t" + r.getTypeToString());
            System.out.println("Amount: \t" + r.getAmount());
            System.out.println("Item id: \t" + r.getTypeID());
            System.out.println("-------------------------------");
        }
    }

    @Override
    public String getName() {
        return "View All Receipts";
    }
}
