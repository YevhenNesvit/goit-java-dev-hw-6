<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Update project</title>
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
            <label for="projectId">Please, enter project_id of project to update:</label><br>
            <input type="text" id="projectId" name="projectId"><br>
            <label for="projectName">name of project to update:</label><br>
            <input type="text" id="projectName" name="projectName"><br>
            <label for="customerId">customer_id of project to update:</label><br>
            <input type="text" id="customerId" name="customerId"><br>
            <label for="companyId">company_id of project to update:</label><br>
            <input type="text" id="companyId" name="companyId"><br>
            <label for="cost">cost of project to update:</label><br>
            <input type="text" id="cost" name="cost"><br>
            <label for="creationDate">creation_date of project to update:</label><br>
            <input type="text" id="creationDate" name="creationDate"><br>
            <button type="submit" class="but">Update</button>
        </form>
    </body>
</html>