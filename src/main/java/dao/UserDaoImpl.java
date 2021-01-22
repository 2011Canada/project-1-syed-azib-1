package dao;

import models.User;
import org.apache.log4j.Logger;
import util.ConnectionFactory;

import java.sql.*;

public class UserDaoImpl {

    private static ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
    Connection conn = this.cf.getConnection();


    private static User sessionUser;
    final static Logger logger = Logger.getLogger(UserDaoImpl.class);


    private static String url="jdbc:postgresql://canada2011-database.c2jpujeqxol7.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=ers";
    private static String aws_user="postgres";
    private static String aws_password="Toronto123";


    public static User getSessionUser() {
        logger.info("get current session user");
        return sessionUser;
    }

    public static void setSessionUser(User sessionUser) {
        logger.info("set session user");
        UserDaoImpl.sessionUser = sessionUser;
    }

    public static void endSession() {
        logger.info("logout");
        sessionUser = null;
    }


    public static User getAccount(String ausername, String apassword) {
        logger.info("login");
        User acct = null;

        //try(Connection conn = DriverManager.getConnection(url, username, password))
        try{
            Class.forName("org.postgresql.Driver");
            Connection conn1 = DriverManager.getConnection(url,aws_user,aws_password);

           /* String sql = "SELECT user_id, first_name, last_name, email, role_id FROM users WHERE user_name = ? AND password = ?;";
            PreparedStatement ps = conn1.prepareStatement(sql);
            ps.setString(1, ausername);
            ps.setString(2, apassword);

            */

            String sql = "SELECT user_id, first_name, last_name, email, role_id FROM users WHERE user_name = '" +ausername + "' AND password = '" + apassword + "';";

            Statement s = conn1.createStatement();
            ResultSet rs = s.executeQuery(sql);

            //ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                acct = new User(rs.getInt("user_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getInt("role_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sessionUser = acct;
        System.out.println(acct);
        return acct;
    }
}
