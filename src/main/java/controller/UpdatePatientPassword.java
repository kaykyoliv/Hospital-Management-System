package controller;

import model.Database;
import model.Patient;

import java.sql.SQLException;

public class UpdatePatientPassword {

    private final Patient p;
    private final Database database;

    public UpdatePatientPassword(Patient p, Database database) {
        this.p = p;
        this.database = database;
    }

    public boolean isUpdated(){
        boolean updated = false;
        String update = "UPDATE patient SET password = '" + p.getPassword() + "' WHERE id = " + p.getID();

        try{
            database.getStatement().executeUpdate(update);
            updated = true;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return updated;
    }

}
