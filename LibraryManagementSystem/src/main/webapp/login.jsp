<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Login</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<div class="login-container">

    <h2>Login</h2>

    <form action="login" method="post">

        <div class="input-group">

            <label>Mobile</label>

            <input
                type="text"
                name="mobile"
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
            Login
        </button>

        <p class="register-text">

            Don't have an account?

            <a href="register.jsp">
                Register
            </a>

        </p>

    </form>

</div>

</body>
</html>