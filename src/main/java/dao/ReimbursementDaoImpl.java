package dao;

import models.Reimbursement;
import org.apache.log4j.Logger;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ReimbursementDaoImpl {


    private static String url="jdbc:postgresql://canada2011-database.c2jpujeqxol7.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=ers";
    private static String aws_user="postgres";
    private static String aws_password="Toronto123";


    public static int createReimbursement(int amt, int authorId, int typeId, String description, Blob receipt) {
        //logger.info("create reimbursement");
        int success = 0;
        try{

            Class.forName("org.postgresql.Driver");
            Connection conn1 = DriverManager.getConnection(url,aws_user,aws_password);

            String sql = "INSERT INTO reimbursement (amount, submitted, description, author, status_id,  type_id ) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn1.prepareStatement(sql);
            ps.setInt(1, amt);
            ps.setDate(2,new Date(System.currentTimeMillis()));
            ps.setString(3, description);
            ps.setInt(4, authorId);
            ps.setInt(5, 1);
            ps.setInt(6, typeId);
            success = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    public static ArrayList<Reimbursement> getEmployeeReimbursements(int empId) {
       // logger.info("get employee reimbursements");
        ArrayList<Reimbursement> list = new ArrayList<>();

        try{
            Class.forName("org.postgresql.Driver");
            Connection conn1 = DriverManager.getConnection(url,aws_user,aws_password);
            String sql = "SELECT reimb_id, amount, submitted, resolved, description, author, status_id, type_id FROM reimbursement WHERE author = ?";
            PreparedStatement ps = conn1.prepareStatement(sql);
            ps.setInt(1, empId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new Reimbursement(rs.getInt("reimb_id"), rs.getInt("amount"), rs.getTimestamp("submitted"), rs.getTimestamp("resolved"), rs.getString("description"), rs.getInt("status_id"), rs.getInt("type_id"), rs.getInt("author")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static ArrayList<Reimbursement> getAllReimbursements() {
       // logger.info("get all reimbursements");
        ArrayList<Reimbursement> list = new ArrayList<>();

        //try(Connection conn = DriverManager.getConnection(url, username, password)) {
        try{
            Class.forName("org.postgresql.Driver");
            Connection conn1 = DriverManager.getConnection(url,aws_user,aws_password);

            String sql = "SELECT * FROM reimbursement";
            PreparedStatement ps = conn1.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
               // list.add(new Reimbursement(rs.getInt("reimb_id"), rs.getInt("reimb_amount"), rs.getString("reimb_submitted"), rs.getString("reimb_resolved"), rs.getString("reimb_description"), rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id"), rs.getInt("reimb_author")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static ArrayList<Reimbursement> getReimbursementsByStatus(int statusId) {
        //logger.info("get reimbursements by status: " + statusId);
        ArrayList<Reimbursement> list = new ArrayList<>();

      //  try(Connection conn = DriverManager.getConnection(url, username, password)) {
        try{
            Class.forName("org.postgresql.Driver");
            Connection conn1 = DriverManager.getConnection(url,aws_user,aws_password);

            String sql = "SELECT * FROM reimbursement WHERE status_id = ?";
            PreparedStatement ps = conn1.prepareStatement(sql);
            ps.setInt(1, statusId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new Reimbursement(rs.getInt("reimb_id"), rs.getInt("amount"), rs.getTimestamp("submitted"), rs.getTimestamp("resolved"), rs.getString("description"), rs.getInt("author"), rs.getInt("resolver"), rs.getInt("status_id"), rs.getInt("type_id")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    public static int resolveReimbursement(int reimbId, int statusId) {
        //logger.info("resolve reimbursement");
        int success = 0;
        //try(Connection conn = DriverManager.getConnection(url, username, password)) {
        try{
            Class.forName("org.postgresql.Driver");
            Connection conn1 = DriverManager.getConnection(url,aws_user,aws_password);

            String sql = "UPDATE reimbursement SET status_id = ? , resolved = ? WHERE reimb_id = ?";
            PreparedStatement ps = conn1.prepareStatement(sql);
            ps.setInt(1, statusId);
            ps.setDate(2,new Date(System.currentTimeMillis()));
            ps.setInt(3, reimbId);
            success = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }



}
