package controller;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class LoginForwardingController {
    //final static Logger logger = Logger.getLogger(LoginForwardingController.class);

    public static String loginPage(HttpServletRequest req) {

//		if (UserDaoImpl.getSessionUser().getUser_role_id() == 1) {
//
//		} else if (UserDaoImpl.getSessionUser().getUser_role_id() == 2) {
//
//		}
        //logger.info("delivering login view");
        return "/html/login.html";
    }
}
