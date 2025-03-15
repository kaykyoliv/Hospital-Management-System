package controller;


import model.Cashier;
import model.Database;
import model.Receipt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadAllReceipts {

    private ArrayList<Receipt> receipts = new ArrayList<>();

    public ReadAllReceipts(Database database) {
        String select = "SELECT * FROM receipt";
        ArrayList<Integer> patientIDs = new ArrayList<>();
        ArrayList<Integer> cashierIDs = new ArrayList<>();
        try (ResultSet rs = database.getStatement().executeQuery(select)) {
            while (rs.next()) {
                Receipt r = new Receipt();
                r.setID(rs.getInt("id"));
                patientIDs.add(rs.getInt("patient_id"));
                cashierIDs.add(rs.getInt("cashier_id"));
                r.setAmount(rs.getDouble("amount"));
                r.setType(rs.getInt("type"));
                r.setTypeID(rs.getInt("item_id"));
                receipts.add(r);
            }
            for (int i = 0; i < receipts.size(); i++) {
                receipts.get(i).setPatient(new ReadPatient(patientIDs.get(i), database).getPatient());
                receipts.get(i).setCashier((Cashier) new ReadEmployee(cashierIDs.get(i), database).getEmployee());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Receipt> getReceipts(){
        return receipts;
    }

}
