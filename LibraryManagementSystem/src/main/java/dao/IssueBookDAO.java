package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import model.IssueBook;
import util.DBConnection;

public class IssueBookDAO {

    // ISSUE BOOK

    public boolean issueBook(IssueBook book) {

        boolean status = false;

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
            "INSERT INTO issued_books(user_id, book_name, author, issue_date, return_date, status) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, book.getUserId());

            ps.setString(2, book.getBookName());

            ps.setString(3, book.getAuthor());

            ps.setString(4, book.getIssueDate());

            ps.setString(5, book.getReturnDate());

            ps.setString(6, book.getStatus());

            int rows =
                    ps.executeUpdate();

            if(rows > 0) {

                status = true;
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return status;
    }


    // VIEW BOOKS HISTORY

    public List<IssueBook> getBooksByUserId(int userId) {

        List<IssueBook> list =
                new ArrayList<>();

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM issued_books WHERE user_id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, userId);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                IssueBook book =
                        new IssueBook();

                // IMPORTANT

                book.setId(
                        rs.getInt("id")
                );

                book.setBookName(
                        rs.getString("book_name")
                );

                book.setAuthor(
                        rs.getString("author")
                );

                book.setIssueDate(
                        rs.getString("issue_date")
                );

                book.setReturnDate(
                        rs.getString("return_date")
                );

                book.setStatus(
                        rs.getString("status")
                );

                list.add(book);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return list;
    }


    // RETURN BOOK

    public boolean returnBook(int id) {

        boolean status = false;

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "UPDATE issued_books SET status='Returned' WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, id);

            int rows =
                    ps.executeUpdate();

            if(rows > 0) {

                status = true;
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return status;
    }
}