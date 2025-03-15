package view;

import controller.ReadAllReceipts;
import controller.ReadCashierReceipt;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewCashierReceipt implements Option {

    @Override
    public void operation(Scanner sc, Database database, User user) {
        ArrayList<Receipt> receipts = new ReadCashierReceipt((Cashier) user, database).getReceipts();
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
        return "View My Receipts";
    }
}
