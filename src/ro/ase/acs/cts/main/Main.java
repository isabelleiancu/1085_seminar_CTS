package ro.ase.acs.cts.main;

import ro.ase.acs.cts.classes.CreateTableOperation;
import ro.ase.acs.cts.classes.InsertDataOperation;
import ro.ase.acs.cts.classes.ReadDataOperation;
import ro.ase.acs.cts.interfaces.DatabaseOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            connection.setAutoCommit(false);

            List<DatabaseOperation> operations = new ArrayList<>();
            operations.add(new CreateTableOperation());
            operations.add(new InsertDataOperation());
            operations.add(new ReadDataOperation());

            for (DatabaseOperation operation : operations) {
                operation.execute(connection);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}