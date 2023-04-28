<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>사원 입력하기</title>
</head>
<body>
    <h1>사원 입력하기</h1>

    <form name="emp" method="post"> <%--id="emp"--%>
<div>사원번호 :     <input type="text" value="${emp.employee_id}" name="employee_id"></div> <%--readonly--%>
<div>이름 :         <input type="text" value="${emp.first_name}" name="first_name"></div>
<div>성 :          <input type="text" value="${emp.lname}" name="lname"></div>
<div>이메일 :       <input type="text" value="${emp.email}" name="email"></div>
<div>전화번호 :     <input type="text" value="${emp.phone}" name="phone"></div>
<div>입사일 :       <input type="text" value="${emp.hdate}" name="hdate"></div>
<div>직책 :        <input type="text" value="${emp.job_id}" name="job_id"></div>
<div>급여 :        <input type="text" value="${emp.sal}" name="sal"></div>
<div>수당 :        <input type="text" value="${emp.comm}" name="comm"></div>
<div>상사번호 :     <input type="text" value="${emp.mgrid}" name="mgrid"></div>
<div>부서번호 :     <input type="text" value="${emp.department_id}" name="department_id"></div>
        <%--<input type="hidden" name="employee_id" value="${emp.employee_id}">--%>
<div><button type="submit">수정완료</button></div>
    </form>

</body>
</html>
