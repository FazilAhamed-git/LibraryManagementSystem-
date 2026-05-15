<%@ page import="model.User" %>

<%

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

%>

<!DOCTYPE html>

<html>

<head>

    <title>
        Issue Book
    </title>

    <link rel="stylesheet"
          href="css/style.css">

</head>

<body>

<div class="login-container">

    <h2>
        Issue Book
    </h2>

    <form action="issueBook"
          method="post">

        <!-- BOOK NAME -->

        <div class="input-group">

            <label>
                Book Name
            </label>

            <input type="text"
                   name="bookName"
                   required>

        </div>


        <!-- AUTHOR -->

        <div class="input-group">

            <label>
                Author
            </label>

            <input type="text"
                   name="author"
                   required>

        </div>


        <!-- ISSUE DATE -->

        <div class="input-group">

            <label>
                Issue Date
            </label>

            <input type="date"
                   name="issueDate"
                   value="<%= java.time.LocalDate.now() %>"
                   readonly>

        </div>


        <!-- AUTO RETURN DATE -->

        <p style="margin-bottom:20px;
                  color:#102A43;
                  font-weight:600;">

            Return Date:

            <strong>

                <%= java.time.LocalDate.now().plusDays(15) %>

            </strong>

        </p>


        <!-- BUTTON -->

        <button type="submit">

            Issue Book

        </button>

    </form>


    <br>

    <a href="home.jsp">

        Back To Home

    </a>


    <br><br>


    <%

    String success =
            request.getParameter(
                    "success"
            );

    String error =
            request.getParameter(
                    "error"
            );

    if(success != null) {

    %>

        <p style="color:green;
                  font-weight:bold;">

            Book Issued Successfully

        </p>

    <%

    }

    if(error != null) {

    %>

        <p style="color:red;
                  font-weight:bold;">

            Failed To Issue Book

        </p>

    <%

    }

    %>

</div>

</body>

</html>