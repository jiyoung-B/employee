<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>사원 입력하기</title>
</head>
<body>
    <h1>사원 입력하기</h1>

    <form name="emp" method="post">
        <div>사원번호 : <input type="text" name="employee_id"></div>
        <div>이름 : <input type="text" name="first_name"></div>
        <div>성 : <input type="text" name="lname"></div>
        <div>이메일 : <input type="text" name="email"></div>
        <div>전화번호 : <input type="text" name="phone"></div>
        <div>입사일 : <input type="text" name="hdate"></div>
        <div>직책 : <input type="text" name="job_id"></div>
        <div>급여 : <input type="text" name="sal"></div>
        <div>수당 : <input type="text" name="comm"></div>
        <div>상사번호 : <input type="text" name="mgrid"></div>
        <div>부서번호 : <input type="text" name="department_id"></div>
        <div><button type="submit">입력완료</button></div>
    </form>

</body>
</html>
