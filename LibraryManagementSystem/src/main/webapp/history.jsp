<%@ page import="java.util.List" %>
<%@ page import="model.IssueBook" %>

<%

List<IssueBook> books =
    (List<IssueBook>) request.getAttribute(
        "books"
    );

%>

<!DOCTYPE html>

<html>

<head>

    <title>
        Issued Books History
    </title>

    <link rel="stylesheet"
          href="css/style1.css">

    <style>

        body {

            background-color: #EEF2F7;
        }

        h2 {

            text-align: center;

            margin-top: 40px;

            color: #102A43;
        }

        table {

            width: 90%;

            margin: 40px auto;

            border-collapse: collapse;

            background: white;

            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }

        th, td {

            padding: 15px;

            border: 1px solid #ddd;

            text-align: center;
        }

        th {

            background-color: #102A43;

            color: white;
        }

        tr:hover {

            background-color: #f5f5f5;
        }

        .return-btn {

            background-color: #28a745;

            color: white;

            padding: 8px 12px;

            text-decoration: none;

            border-radius: 6px;

            font-size: 14px;
        }

        .return-btn:hover {

            background-color: #218838;
        }

        .returned-text {

            color: green;

            font-weight: bold;
        }

        .back-btn {

            display: block;

            width: 220px;

            margin: 30px auto;

            text-align: center;

            background: #102A43;

            color: white;

            padding: 12px;

            border-radius: 8px;

            text-decoration: none;

            font-weight: 600;
        }

        .back-btn:hover {

            background: #0b1b2a;
        }

    </style>

</head>

<body>

<h2>
    Issued Books History
</h2>

<table>

    <tr>

        <th>
            Book Name
        </th>

        <th>
            Author
        </th>

        <th>
            Issue Date
        </th>

        <th>
            Return Date
        </th>

        <th>
            Status
        </th>

        <th>
            Action
        </th>

    </tr>

<%

if(books != null) {

    for(IssueBook book : books) {

%>

<tr>

    <td>
        <%= book.getBookName() %>
    </td>

    <td>
        <%= book.getAuthor() %>
    </td>

    <td>
        <%= book.getIssueDate() %>
    </td>

    <td>
        <%= book.getReturnDate() %>
    </td>

    <td>
        <%= book.getStatus() %>
    </td>

    <td>

    <%

    if(!book.getStatus().equals("Returned")) {

    %>

        <a href="returnBook?id=<%= book.getId() %>"
           class="return-btn">

           Return Book

        </a>

    <%

    } else {

    %>

        <span class="returned-text">

            Returned

        </span>

    <%

    }

    %>

    </td>

</tr>

<%

    }
}

%>

</table>

<a href="home.jsp"
   class="back-btn">

   Back To Home

</a>

</body>

</html>