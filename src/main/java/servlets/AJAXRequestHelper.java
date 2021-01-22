package servlets;

import com.fasterxml.jackson.core.JsonProcessingException;
import controller.ReimbursementAJAXController;
import controller.UserAJAXController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AJAXRequestHelper {
    public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {

        System.out.println("THIS is the current URI active: "+req.getRequestURI());

        switch (req.getRequestURI()) {
            case "/getAccount":
                System.out.println("in get account case");
                UserAJAXController.getAccount(req, res);
                break;
            case "/doCreateReimbursement":
                System.out.println("in create reimbursement case");
                ReimbursementAJAXController.doCreateReimbursement(req, res);
                break;
            case "/doResolveReimbursement":
                System.out.println("in resolve case");
                ReimbursementAJAXController.doResolveReimbursement(req, res);
                break;
            case "/getAllReimbursements":
                System.out.println("in get all case");
                ReimbursementAJAXController.getAll(req, res);
                break;
            case "/getApprovedReimbursements":
                System.out.println("in get approved case");
                ReimbursementAJAXController.getApproved(req, res);
                break;
            case "/getDeniedReimbursements":
                System.out.println("in get denied case");
                ReimbursementAJAXController.getDenied(req, res);
                break;
            case "/getPendingReimbursements":
                System.out.println("in get pending case");
                ReimbursementAJAXController.getPending(req, res);
                break;
            case "/getEmployeeReimbursements":
                System.out.println("in get employee reimbursements case");
                ReimbursementAJAXController.getEmployeeReimbursements(req, res);
                break;
            case "/logout":
                System.out.println("in logout case");
                UserAJAXController.logout(req, res);
                break;
            case "/getSessionType":
                System.out.println("in get session case");
                UserAJAXController.getSessionType(req, res);
                break;
            default:
                System.out.println("in default case");
        }
    }

}
