package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static ConnectionFactory cf = new ConnectionFactory(1);

    //provide a single point of access to the connection factory
    public static ConnectionFactory getConnectionFactory() {
        return cf;
    }


    //this holds all of our connections
    //we could potential implement this as a connection pool, however, this one only implements a single connection
    private Connection[] conn;

    //this is a very basic factory
    //only a single param for configuration
    //if the singleton pattern is used all of the constructors must be private
    //otherwise others could make new instances and that would no longer be a singleton pattern.
    private ConnectionFactory(int numberOfConnections) {

        String url = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");
        try {
            this.conn = new Connection[numberOfConnections];
            for(int i = 0; i< this.conn.length; i++) {
                Connection conn = DriverManager.getConnection(url, user, password);
                this.conn[i] = conn;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //In a real situation one would need multiple threading for multiple connections but in this case there's only 1
    public Connection getConnection() {
        //TODO
        return this.conn[0];
    }

    public void releaseConnection(Connection conn) {
        //TODO
    }


}
