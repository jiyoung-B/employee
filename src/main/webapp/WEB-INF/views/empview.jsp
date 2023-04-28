<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>사원 조회</title>
</head>
<body>
    <h1>사원 조회</h1>
    <table border="1" width="750px" cellpadding="10px" cellspacing="0">
        <tr>
            <th>employee_id</th>
            <th>first_name</th>
            <th>last_name</th>
            <th>email</th>
            <th>job_id</th>
            <th>phone</th>
            <th>department_id</th>
            <td>hdate</td>
            <td>sal</td>
            <td>comm</td>
            <td>mgrid</td>
        </tr>
<%--for(SungJuk sj : sjs)--%>

            <tr>
<%--                <td><a href="/view?employee_id=${emp.employee_id}">${emp.employee_id}</a></td>--%>
                <td>${emp.employee_id}</td>
                <td>${emp.first_name}</td>
                <td>${emp.lname}</td>
                <td>${emp.email}</td>
                <td>${emp.job_id}</td>
                <td>${emp.phone}</td>
                <td>${emp.department_id}</td>
                <td>${emp.hdate}</td>
                <td>${emp.sal}</td>
                <td>${emp.comm}</td>
                <td>${emp.mgrid}</td>
            </tr>

    </table>

    <p><a href="/modify?employee_id=${emp.employee_id}">수정하기</a></p>
    <p><a href="/remove?employee_id=${emp.employee_id}">삭제하기</a></p>

</body>
</html>
