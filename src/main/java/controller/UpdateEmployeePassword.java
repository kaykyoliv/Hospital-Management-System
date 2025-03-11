package controller;

import model.Database;
import model.User;

import java.sql.SQLException;

public class UpdateEmployeePassword {

    private User u;
    private Database database;

    public UpdateEmployeePassword(User u, Database database) {
        this.u = u;
        this.database = database;
    }

    public boolean isUpdated(){
        boolean updated = false;
        String update = "UPDATE employee SET password = '" + u.getPassword() + "' WHERE id = " + u.getID();

        try{
            int rowsAffected = database.getStatement().executeUpdate(update);
            System.out.println(rowsAffected);
            updated = true;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return updated;
    }
}
