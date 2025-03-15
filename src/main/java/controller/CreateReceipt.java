package controller;

import model.Database;
import model.Receipt;

import java.sql.SQLException;

public class CreateReceipt {

    private Receipt receipt;
    private Database database;

    public CreateReceipt(Receipt receipt, Database database) {
        this.receipt = receipt;
        this.database = database;
    }

    public boolean isCreated(){
        boolean created = false;
        String update = "";
        if (receipt.getType() == 0) { // operation
            update = "UPDATE operation SET paid = true WHERE id = " + receipt.getTypeID();
        }
        if (receipt.getType() == 1) { // report
            update = "UPDATE report SET paid = true WHERE id = " + receipt.getTypeID();
        }
        String create = "INSERT INTO receipt (cashier_id, patient_id, amount, type, item_id) " +
                "VALUES (" + receipt.getCashier().getID() + ", " + receipt.getPatient().getID() + ", " + receipt.getAmount() +
                ", " + receipt.getType() + ", " + receipt.getTypeID() + ")";
        try{
            database.getStatement().execute(create);
            database.getStatement().execute(update);
            created = true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return created;
    }
}
