<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Skills</title>
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
          <h2>Skills</h2>
            <table border="2">
              <tr><th>skill_id</th><th>name</th><th>skill_level</th></tr>
                <c:forEach var="skill" items="${skills}">
                  <tr><td>${skill.skillId}</td>
                    <td>${skill.name}</td>
                    <td>${skill.skillLevel}</td>
                  </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>