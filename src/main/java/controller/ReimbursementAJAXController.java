package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserDaoImpl;
import models.Reimbursement;
import org.apache.log4j.Logger;
import services.ReimbursementService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ReimbursementAJAXController {
    final static Logger logger = Logger.getLogger(ReimbursementAJAXController.class);

    public static void doCreateReimbursement(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
        logger.info("doCreate R AJAX");
        int num = ReimbursementService.createReimbursement(Integer.parseInt(req.getParameter("amt")), UserDaoImpl.getSessionUser().getId(), Integer.parseInt(req.getParameter("type")), req.getParameter("desc"), null);
        res.getWriter().write(new ObjectMapper().writeValueAsString(num));
    }

    public static void doResolveReimbursement(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
        logger.info("doResolve R AJAX");
        int num = ReimbursementService.resolveReimbursement(Integer.parseInt(req.getParameter("id")), Integer.parseInt(req.getParameter("status")));
        res.getWriter().write(new ObjectMapper().writeValueAsString(num));
    }

    public static void getAll(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
        logger.info("getAll AJAX");
        ArrayList<Reimbursement> list = ReimbursementService.getAllReimbursements();
        res.getWriter().write(new ObjectMapper().writeValueAsString(list));
    }

    public static void getApproved(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
        logger.info("getApproved AJAX");
        ArrayList<Reimbursement> list = ReimbursementService.getReimbursementsByStatus(2);
        res.getWriter().write(new ObjectMapper().writeValueAsString(list));
    }

    public static void getDenied(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
        logger.info("getDenied AJAX");
        ArrayList<Reimbursement> list = ReimbursementService.getReimbursementsByStatus(3);
        res.getWriter().write(new ObjectMapper().writeValueAsString(list));
    }

    public static void getPending(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
        logger.info("getPending AJAX");
        ArrayList<Reimbursement> list = ReimbursementService.getReimbursementsByStatus(1);
        res.getWriter().write(new ObjectMapper().writeValueAsString(list));
    }

    public static void getEmployeeReimbursements(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
        logger.info("getEmployee Rs AJAX");
        ArrayList<Reimbursement> list = ReimbursementService.getEmployeeReimbursements(UserDaoImpl.getSessionUser().getId());
        res.getWriter().write(new ObjectMapper().writeValueAsString(list));
    }

}
