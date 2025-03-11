package controller;

import model.Database;

import java.sql.SQLException;

public class DeleteEmployee {

    private int id;
    private Database database;

    public DeleteEmployee(int id, Database database) {
        this.id = id;
        this.database = database;
    }

    public boolean isDeleted(){
        boolean deleted = false;
        String delete = "DELETE FROM employee WHERE id = " + id;
        try{
            database.getStatement().execute(delete);
            deleted = true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return deleted;
    }
}
