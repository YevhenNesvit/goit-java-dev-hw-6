<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Company by id</title>
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
                padding-left: 47px;
                padding-right: 47px;
            }
        </style>
    </head>
    <body>
        <c:import url="${contextPath}/WEB-INF/view/navigationBar.jsp"/>
        <div class ="center">
          <h2>Company</h2>
            <table border="2">
              <tr><th>company_id</th><th>name</th><th>country</th></tr>
                <c:forEach var="company" items="${companies}">
                  <tr><td>${company.companyId}</td>
                    <td>${company.name}</td>
                    <td>${company.country}</td>
                  </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>