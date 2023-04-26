<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>사원 리스트</title>
</head>
<body>
    <h1>사원 리스트</h1>
    <table border="1" width="750px" cellpadding="10px" cellspacing="0">
        <tr>
            <th>employee_id</th>
            <th>first_name</th>
            <th>email</th>
            <th>job_id</th>
            <th>department_id</th>
        </tr>
<%--for(SungJuk sj : sjs)--%>
        <c:forEach items="${emp}" var="emp">
            <tr>
                <td>${emp.employee_id}</td>
                <td>${emp.first_name}</td>
                <td>${emp.email}</td>
                <td>${emp.job_id}</td>
                <td>${emp.department_id}</td>
            </tr>
        </c:forEach>
    </table>

<p>${emp}</p>

</body>
</html>
