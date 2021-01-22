package services;

import dao.ReimbursementDaoImpl;
import models.Reimbursement;

import java.sql.Blob;
import java.util.ArrayList;

public class ReimbursementService {
    public static int createReimbursement(int amt, int authorId, int typeId, String description, Blob receipt) {
    return ReimbursementDaoImpl.createReimbursement(amt, authorId, typeId, description, receipt);
}

    public static ArrayList<Reimbursement> getEmployeeReimbursements(int empId) {
        return ReimbursementDaoImpl.getEmployeeReimbursements(empId);
    }

    public static ArrayList<Reimbursement> getAllReimbursements() {
        return ReimbursementDaoImpl.getAllReimbursements();
    }

    public static ArrayList<Reimbursement> getReimbursementsByStatus(int statusId) {
        return ReimbursementDaoImpl.getReimbursementsByStatus(statusId);
    }


    public static int resolveReimbursement(int reimbId, int statusId) {
        return ReimbursementDaoImpl.resolveReimbursement(reimbId, statusId);
    }
}
