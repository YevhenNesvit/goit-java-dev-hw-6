<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Project by id</title>
        <style>
            .center {
                text-align: center;
                margin-top: 11%;
            }
            table {
                width: 380px;
                border: 1px solid black;
                margin: auto;
                text-align: center;
                border-collapse: collapse;
            }
            th {
                padding-left: 38px;
                padding-right: 38px;
            }
        </style>
    </head>
    <body>
        <c:import url="${contextPath}/WEB-INF/view/navigationBar.jsp"/>
        <div class ="center">
          <h2>Project</h2>
            <table border="2">
              <tr><th>project_id</th><th>name</th><th>customer_id</th><th>company_id</th><th>cost</th><th>creation_date</th></tr>
                <c:forEach var="project" items="${projects}">
                  <tr><td>${project.projectId}</td>
                    <td>${project.name}</td>
                    <td>${project.customerId}</td>
                    <td>${project.companyId}</td>
                    <td>${project.cost}</td>
                    <td>${project.creationDate}</td>
                  </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>