package controller;

import java.io.IOException;
import java.util.List;

import dao.IssueBookDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.IssueBook;
import model.User;

public class ViewBooksServlet extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        HttpSession session =
                request.getSession();

        User user =
                (User) session.getAttribute(
                        "currentUser"
                );

        if(user == null) {

            response.sendRedirect(
                    "login.jsp"
            );

            return;
        }

        IssueBookDAO dao =
                new IssueBookDAO();

        List<IssueBook> books =
                dao.getBooksByUserId(
                        user.getId()
                );

        request.setAttribute(
                "books",
                books
        );

        request.getRequestDispatcher(
                "history.jsp"
        ).forward(
                request,
                response
        );
    }
}