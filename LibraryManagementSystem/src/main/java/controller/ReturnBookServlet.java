package controller;

import java.io.IOException;

import dao.IssueBookDAO;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

public class ReturnBookServlet
        extends HttpServlet {

    protected void doGet(

            HttpServletRequest request,

            HttpServletResponse response

    ) throws ServletException, IOException {

        int id =
                Integer.parseInt(
                        request.getParameter("id")
                );

        IssueBookDAO dao =
                new IssueBookDAO();

        dao.returnBook(id);

        response.sendRedirect(
                "viewBooks"
        );
    }
}