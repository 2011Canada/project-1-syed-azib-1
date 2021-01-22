package controller;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class ManagerForwardingController {
    final static Logger logger = Logger.getLogger(ManagerForwardingController.class);

    public static String viewAllPage(HttpServletRequest req) {
        logger.info("delivering view all view");
        return "/html/managerViewAll.html";
    }

    public static String viewApprovedPage(HttpServletRequest req) {
        logger.info("delivering view approved view");
        return "/html/managerViewApproved.html";
    }

    public static String viewDeniedPage(HttpServletRequest req) {
        logger.info("delivering view denied view");
        return "/html/managerViewDenied.html";
    }

    public static String viewPendingPage(HttpServletRequest req) {
        logger.info("delivering view pending view");
        return "/html/managerViewPending.html";
    }

}
