package controller;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class EmployeeForwardingController {
    //final static Logger logger = Logger.getLogger(EmployeeForwardingController.class);

    public static String employeePage(HttpServletRequest req) {
        //logger.info("delivering employee view");
        return "/html/Employee.html";
    }
}
