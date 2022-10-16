<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Create company</title>
        <style>
            .center {
                text-align: center;
                margin-top: 11%;
            }
            .but {
                margin-top: .2%;
            }
        </style>
    </head>
    <body>
        <c:import url="${contextPath}/WEB-INF/view/navigationBar.jsp"/>
        <form method="post" class="center">
            <label for="companyId">Please, enter company_id of new company:</label><br>
            <input type="text" id="companyId" name="companyId"><br>
            <label for="companyName">name of new company:</label><br>
            <input type="text" id="companyName" name="companyName"><br>
            <label for="country">country of new company:</label><br>
            <input type="text" id="country" name="country"><br>
            <button type="submit" class="but">Create</button>
        </form>
    </body>
</html>