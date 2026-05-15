package controller;

import java.io.IOException;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;



public class LoginServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        String mobile =
                request.getParameter("mobile");

        String password =
                request.getParameter("password");

        UserDAO dao = new UserDAO();

        User user =
                dao.loginUser(mobile, password);

        if(user != null) {

            HttpSession session =
                    request.getSession();

            session.setAttribute(
                    "currentUser",
                    user
            );

            response.sendRedirect(
                    "home.jsp"
            );

        } else {

            response.getWriter().println(
                    "Invalid Mobile or Password"
            );
        }
    }
}