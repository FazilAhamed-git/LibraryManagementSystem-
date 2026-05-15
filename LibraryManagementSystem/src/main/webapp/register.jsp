<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>

    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="login-container">

    <h2>Create Account</h2>

    <form action="register" method="post">

        <div class="input-group">
            <label>Full Name</label>

            <input
                type="text"
                name="name"
                required
            >
        </div>

        <div class="input-group">
            <label>Mobile</label>

            <input
                type="text"
                name="mobile"
                required
            >
        </div>

        <div class="input-group">
            <label>Email</label>

            <input
                type="email"
                name="email"
                required
            >
        </div>

        <div class="input-group">
            <label>Password</label>

            <input
                type="password"
                name="password"
                required
            >
        </div>

        <button type="submit">
            Register
        </button>

        <p class="register-text">
            Already registered?

            <a href="login.jsp">
                Login
            </a>
        </p>

    </form>

</div>

</body>
</html>