<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Invalid inputs format</title>
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
          <h2><b>Invalid value. Please, use digits for project_id, customer_id, company_id, cost rows and YYYY-MM-DD format
          for creation_date</b></h2>
          <p><a href="/createProjectForm">Create project</a></p>
          <p><a href="/deleteProjectForm">Delete project</a></p>
          <p><a href="/getProjectByIdForm">Get project by id</a></p>
          <p><a href="/updateProjectForm">Update project</a></p>
          <p><a href="/getDevelopersByProjectForm">Get developers by project</a></p>
          <p><a href="/getSalaryByProjectForm">Get salary by project</a></p>
        </div>
    </body>
</html>