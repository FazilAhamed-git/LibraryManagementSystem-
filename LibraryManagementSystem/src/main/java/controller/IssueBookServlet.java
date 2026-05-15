package controller;

import java.io.IOException;
import java.time.LocalDate;

import dao.IssueBookDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;

import model.IssueBook;
import model.User;

public class IssueBookServlet extends HttpServlet {

    protected void doPost(

            HttpServletRequest request,

            HttpServletResponse response

    ) throws ServletException, IOException {

        HttpSession session =
                request.getSession();

        User user =
                (User) session.getAttribute(
                        "currentUser"
                );

        String bookName =
                request.getParameter("bookName");

        String author =
                request.getParameter("author");

        String issueDate =
                request.getParameter("issueDate");


        // AUTO RETURN DATE = 15 DAYS

        LocalDate returnDate =
                LocalDate.now().plusDays(15);


        IssueBook book =
                new IssueBook();

        book.setUserId(
                user.getId()
        );

        book.setBookName(
                bookName
        );

        book.setAuthor(
                author
        );

        book.setIssueDate(
                issueDate
        );

        book.setReturnDate(
                returnDate.toString()
        );

        book.setStatus(
                "Issued"
        );


        IssueBookDAO dao =
                new IssueBookDAO();

        boolean status =
                dao.issueBook(book);


        if(status) {

            response.sendRedirect(
                    "issueBook.jsp?success=true"
            );

        } else {

            response.sendRedirect(
                    "issueBook.jsp?error=true"
            );
        }
    }
}