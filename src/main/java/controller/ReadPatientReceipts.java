package controller;

import model.Cashier;
import model.Database;
import model.Patient;
import model.Receipt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadPatientReceipts {
    private ArrayList<Receipt> receipts = new ArrayList<>();

    public ReadPatientReceipts(Patient p, Database database) {
        String select = "SELECT * FROM receipt WHERE patient_id = " + p.getID();
        ArrayList<Integer> cashierIDs = new ArrayList<>();
        try (ResultSet rs = database.getStatement().executeQuery(select)) {
            while (rs.next()) {
                Receipt r = new Receipt();
                r.setID(rs.getInt("id"));
                r.setPatient(p);
                cashierIDs.add(rs.getInt("cashier_id"));
                r.setAmount(rs.getDouble("amount"));
                r.setType(rs.getInt("type"));
                r.setTypeID(rs.getInt("item_id"));
                receipts.add(r);
            }
            for (int i = 0; i < receipts.size(); i++) {
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
