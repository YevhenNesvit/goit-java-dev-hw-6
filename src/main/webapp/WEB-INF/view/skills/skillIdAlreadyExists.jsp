<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Skill id already exists</title>
        <style>
           .center {
            text-align: center;
            margin-top: 11%;
           }
          </style>
    </head>
    <body>
        <c:import url="${contextPath}/WEB-INF/view/navigationBar.jsp"/>
        <div class="center">
          <h2><b>skill_id already exists. Please, retry</b></h2>
          <p><a href="/createSkillForm">Create skill</a></p>
        </div>
    </body>
</html>