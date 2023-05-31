<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome to Our Website</title>
    <style>
        body {
            background-image: url('stars.png');
            background-size: cover;
            background-position: center;
            margin: 0; /* Reset default body margin */
        }

        .container {
            width: 400px;
            height: 300px;
            margin: 70px auto 0; /* Updated margin to position the container at the top */
            background-color: #333;
            border-radius: 20px;
            text-align: center;
            padding-top: 80px;
            color: #fff;
            font-size: 24px;
        }

        .submit-button {
            width: 200px;
            height: 60px;
            font-size: 24px;
            background-color: #9dc3e6;
            color: #00008B; /* dark blue color */
            border: none;
            border-radius: 10px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <%! Object hey; %>
    <% hey = (String) request.getAttribute("username"); %>
    <div class="container">
        <p> Welcome <%= hey %>!!</p>
        <br>
        <p> report a violation?</p>
        <form action="../Date" method="post">
            <button class="submit-button" name="Button">Report</button>
        </form>

        <br>
    </div>
</body>
</html>
