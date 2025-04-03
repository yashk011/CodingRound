package org.example.designPattern.ObjectPoolPattern;

import java.util.ArrayList;
import java.util.List;

public class DatabaseConnectionPoolManager {
    static DatabaseConnectionPoolManager instance;
    List<DatabaseConnection> freeConnection = new ArrayList<>();
    List<DatabaseConnection> userConnection = new ArrayList<>();

    int MAX_POOL_SIZE = 4;
    int INITIAL_POOL_SIZE = 3;
    private DatabaseConnectionPoolManager() {
        freeConnection.add(new DatabaseConnection("A","B","C"));
        freeConnection.add(new DatabaseConnection("A","B","C"));
        freeConnection.add(new DatabaseConnection("A","B","C"));
    }

    public static DatabaseConnectionPoolManager getInstance() {
        if(instance == null) {
            synchronized (DatabaseConnectionPoolManager.class) {
                if(instance == null)
                    instance = new DatabaseConnectionPoolManager();
            }
        }
        return instance;
    }

    public synchronized DatabaseConnection getDatabaseConnection() {
        if(!freeConnection.isEmpty()) {
            System.out.println("Get exiting connection from object pool");
            DatabaseConnection dc = freeConnection.remove(freeConnection.size()-1);
            userConnection.add(dc);
            return dc;
        }
        if(freeConnection.isEmpty() && userConnection.size() < MAX_POOL_SIZE) {
            System.out.println("Creating new Connection");
            DatabaseConnection  dc = new DatabaseConnection("T","U","F");
            userConnection.add(dc);
            return dc;
        }

        System.out.println("DC Not available");
        return null;
    }

    public synchronized void releaseConnection(DatabaseConnection dc) {
        if(dc != null) {
            System.out.println("Removing data connection from used pool space");
            userConnection.remove(dc);
            System.out.println("Adding data connection from free pool space");
            freeConnection.add(dc);
        }
    }
}
