package model;

public class IssueBook {

    private int id;

    private int userId;

    private String bookName;

    private String author;

    private String issueDate;

    private String returnDate;

    private String status;

   

    public int getId() {

        return id;
    }


    public void setId(int id) {

        this.id = id;
    }

   

    public int getUserId() {

        return userId;
    }


    public void setUserId(int userId) {

        this.userId = userId;
    }

    public String getBookName() {

        return bookName;
    }


    public void setBookName(String bookName) {

        this.bookName = bookName;
    }

   

    public String getAuthor() {

        return author;
    }

    public void setAuthor(String author) {

        this.author = author;
    }

    public String getIssueDate() {

        return issueDate;
    }

    public void setIssueDate(String issueDate) {

        this.issueDate = issueDate;
    }

    public String getReturnDate() {

        return returnDate;
    }

    public void setReturnDate(String returnDate) {

        this.returnDate = returnDate;
    }

    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {

        this.status = status;
    }
}