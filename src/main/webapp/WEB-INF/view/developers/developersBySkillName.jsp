<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Developers by skill name</title>
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
               padding-left: 11px;
               padding-right: 11px;
            }
        </style>
    </head>
    <body>
        <c:import url="${contextPath}/WEB-INF/view/navigationBar.jsp"/>
        <div class ="center">
          <h2>Developers</h2>
            <table border="2">
              <tr><th>developer_id</th><th>first_name</th><th>last_name</th><th>gender</th><th>age</th><th>company_id</th>
                <th>salary</th></tr>
                <c:forEach var="developer" items="${developers}">
                  <tr><td>${developer.developerId}</td>
                    <td>${developer.firstName}</td>
                    <td>${developer.lastName}</td>
                    <td>${developer.gender}</td>
                    <td>${developer.age}</td>
                    <td>${developer.companyId}</td>
                    <td>${developer.salary}</td>
                  </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>