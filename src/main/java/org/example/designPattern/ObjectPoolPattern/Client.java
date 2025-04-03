package org.example.designPattern.ObjectPoolPattern;

public class Client {
    public static void main(String[] args) {
        DatabaseConnectionPoolManager manager = DatabaseConnectionPoolManager.getInstance() ;

        DatabaseConnection databaseConnection = manager.getDatabaseConnection();
        DatabaseConnection databaseConnection2 = manager.getDatabaseConnection();
        DatabaseConnection databaseConnection3 = manager.getDatabaseConnection();
        DatabaseConnection databaseConnection4 = manager.getDatabaseConnection();
        DatabaseConnection databaseConnection5 = manager.getDatabaseConnection();

        if(databaseConnection != null)
            databaseConnection.connect();
        else
            System.out.println("Connection Pool used fully");

        if(databaseConnection5 != null)
            databaseConnection5.connect();
        else
            System.out.println("Connection Pool used fully");

        manager.releaseConnection(databaseConnection2);
        databaseConnection5 = manager.getDatabaseConnection();
        databaseConnection5.connect();
    }
}
