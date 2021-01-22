package servlets;

import controller.EmployeeForwardingController;
import controller.LoginForwardingController;
import controller.ManagerForwardingController;

import javax.servlet.http.HttpServletRequest;

public class ForwardingRequestHelper {
    public static String process(HttpServletRequest req) {


        System.out.println("THIS is the current URI active: "+req.getRequestURI());

        switch (req.getRequestURI()) {
            case "/login":
                System.out.println("in login case");
                return LoginForwardingController.loginPage(req);
            case "/employee":
                System.out.println("in employee case");
                return EmployeeForwardingController.employeePage(req);
            case "/managerViewAll":
                System.out.println("in view all case");
                return ManagerForwardingController.viewAllPage(req);
            case "/managerViewApproved":
                System.out.println("in approved case");
                return ManagerForwardingController.viewApprovedPage(req);
            case "/managerViewDenied":
                System.out.println("in denied case");
                return ManagerForwardingController.viewDeniedPage(req);
            case "/managerViewPending":
                System.out.println("in pending case");
                return ManagerForwardingController.viewPendingPage(req);
            default:
                return "/html/login.html";
        }
    }

}
