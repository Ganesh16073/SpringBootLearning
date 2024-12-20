<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page isELIgnored="false"%>


<!DOCTYPE html>
<html>
<head>
    <title>Contact Us</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .container { width: 50%; margin: auto; padding: 20px; }
        .success { color: green; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Contact Us</h1>
        
        <c:if test="${not empty successMessage}">
            <p class="success">${successMessage}</p>
        </c:if>
        
        <form method="post" action="/contactus">
            <label for="name">Name:</label><br>
            <input type="text" id="name" name="name" required><br><br>

            <label for="email">Email:</label><br>
            <input type="email" id="email" name="email" required><br><br>

            <label for="message">Message:</label><br>
            <textarea id="message" name="message" rows="4" required></textarea><br><br>

            <button type="submit">Submit</button>
        </form>
    </div>
</body>
</html>
