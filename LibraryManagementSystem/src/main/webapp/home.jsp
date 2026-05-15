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

    <meta charset="UTF-8">

    <title>
        Library Management System
    </title>

    <link rel="stylesheet"
          href="css/style1.css">

    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>

<body>

<!-- NAVBAR -->

<header class="navbar">

    <div class="logo">
        LibraryMS
    </div>

    <nav>

        <a href="#home">
            Home
        </a>

        <a href="#about">
            About
        </a>

        <a href="#features">
            Features
        </a>

        <a href="#contact">
            Contact
        </a>

        <a href="issueBook.jsp"
           class="issue-btn">

           Issue Book

        </a>

        <a href="viewBooks"
           class="login-btn">

           View Books

        </a>

        <a href="logout"
           class="login-btn">

           Logout

        </a>

    </nav>

</header>


<!-- HERO SECTION -->

<section class="hero"
         id="home">

    <h1>
        Welcome, <%= user.getName() %>
    </h1>

    <p>
        Smart and Simple Library Management System
    </p>

</section>


<!-- ABOUT SECTION -->

<section class="section"
         id="about">

    <h2>
        About Our Library
    </h2>

    <p>
        This Library Management System helps students and librarians
        manage issued books, track return dates, and maintain records
        efficiently.
    </p>

    <p>
        Built using JSP, Servlets, JDBC, and MySQL,
        this application demonstrates real-world Java web development concepts.
    </p>

</section>


<!-- FEATURES SECTION -->

<section class="section light"
         id="features">

    <h2>
        System Features
    </h2>

    <div class="features-grid">

        <div class="feature-card">

            <img src="images/e-library"
                 alt="Books">

            <h3>
                Book Management
            </h3>

            <p>
                Issue and return books easily with automatic return tracking.
            </p>

        </div>


        <div class="feature-card">

            <img src="images/Screenshot_15-5-2026_213522_www.bing.com.jpeg"
                 alt="History">

            <h3>
                History Tracking
            </h3>

            <p>
                View issued books history for every logged-in user.
            </p>

        </div>


        <div class="feature-card">

            <img src="images/Screenshot_15-5-2026_213615_www.bing.com.jpeg"
                 alt="Security">

            <h3>
                Secure Login
            </h3>

            <p>
                Authentication and session management using Java Servlets.
            </p>

        </div>

    </div>

</section>


<!-- CONTACT SECTION -->

<section class="contact"
         id="contact">

    <h2>
        Contact Us
    </h2>

    <p class="contact-text">
        Reach out for support or inquiries.
    </p>


    <div class="contact-card">

        <p>
            <strong>Email:</strong>
            librarysupport@gmail.com
        </p>

        <p>
            <strong>Phone:</strong>
            +91 9876543210
        </p>

        <p>
            <strong>Location:</strong>
            Chennai, Tamil Nadu
        </p>

    </div>

</section>

</body>
</html>
