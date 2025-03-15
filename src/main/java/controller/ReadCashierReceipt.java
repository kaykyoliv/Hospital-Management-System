package controller;

import model.Cashier;
import model.Database;
import model.Patient;
import model.Receipt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadCashierReceipt {
    private ArrayList<Receipt> receipts = new ArrayList<>();

    public ReadCashierReceipt(Cashier c, Database database) {
        String select = "SELECT * FROM receipt WHERE cashier_id = " + c.getID();
        ArrayList<Integer> patientIDs = new ArrayList<>();

        try (ResultSet rs = database.getStatement().executeQuery(select)) {
            while (rs.next()) {
                Receipt r = new Receipt();
                r.setID(rs.getInt("id"));
                patientIDs.add(rs.getInt("patient_id"));
                r.setCashier(c);
                r.setAmount(rs.getDouble("amount"));
                r.setType(rs.getInt("type"));
                r.setTypeID(rs.getInt("item_id"));
                receipts.add(r);
            }
            for (int i = 0; i < receipts.size(); i++) {
                receipts.get(i).setPatient(new ReadPatient(patientIDs.get(i), database).getPatient());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Receipt> getReceipts(){
        return receipts;
    }
}
