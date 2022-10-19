<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Update developer</title>
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
            <label for="developerId">Please, enter developer_id of developer to update:</label><br>
            <input type="text" id="developerId" name="developerId"><br>
            <label for="firstName">first_name of developer to update:</label><br>
            <input type="text" id="firstName" name="firstName"><br>
            <label for="lastName">last_name of developer to update:</label><br>
            <input type="text" id="lastName" name="lastName"><br>
            <label for="gender">gender of developer to update like M or F:</label><br>
            <input type="text" id="gender" name="gender"><br>
            <label for="age">age of developer to update:</label><br>
            <input type="text" id="age" name="age"><br>
            <label for="companyId">company_id of developer to update:</label><br>
            <input type="text" id="companyId" name="companyId"><br>
            <label for="salary">salary of developer to update:</label><br>
            <input type="text" id="salary" name="salary"><br>
            <button type="submit" class="but">Update</button>
        </form>
    </body>
</html>