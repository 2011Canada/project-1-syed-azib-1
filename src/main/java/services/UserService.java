package services;

import dao.UserDaoImpl;
import models.User;

public class UserService {

    public static User getAccount(String ausername, String apassword) {
        return UserDaoImpl.getAccount(ausername, apassword);
    }

    public static void endSession() {
        UserDaoImpl.endSession();;
    }
}
