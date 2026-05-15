package controller;

import java.io.IOException;

import dao.UserDAO;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;



public class RegisterServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        String name = request.getParameter("name");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User(
                name,
                mobile,
                email,
                password
        );

        UserDAO dao = new UserDAO();

        boolean status = dao.registerUser(user);

        if(status) {

            response.sendRedirect("login.jsp");

        } else {

            response.getWriter().println(
                    "Registration Failed"
            );
        }
    }
}