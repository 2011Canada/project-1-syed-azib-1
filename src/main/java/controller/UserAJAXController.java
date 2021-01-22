package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserDaoImpl;
import models.User;
import org.apache.log4j.Logger;
import services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UserAJAXController {
    final static Logger logger = Logger.getLogger(UserAJAXController.class);

    public static void getAccount(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
        logger.info("getAccount AJAX");
        String body = getBody(req);
        String[] split = body.split("\"");
        String usernamePresented = split[3];
        String passwordPresented = split[7];

        User user = UserService.getAccount(usernamePresented, passwordPresented);
        res.getWriter().write(new ObjectMapper().writeValueAsString(user));
    }

    public static void logout(HttpServletRequest req, HttpServletResponse res) {
        logger.info("logout AJAX");
        UserDaoImpl.endSession();
    }

    public static void getSessionType(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
        logger.info("getSessionType AJAX");
        User session = UserDaoImpl.getSessionUser();
        if (session != null) {
            res.getWriter().write(new ObjectMapper().writeValueAsString(session.getUser_role_id()));
        } else {
            res.getWriter().write(new ObjectMapper().writeValueAsString(null));
        }
    }

    public static String getBody(HttpServletRequest request) throws IOException {

        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }

        body = stringBuilder.toString();
        body = body.substring(1, body.length()-1);

        return body;

    }
}
