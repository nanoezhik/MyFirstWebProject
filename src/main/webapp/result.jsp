
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result Repots List</title>
</head>
<body>
<br/>
<h2>Repots List:</h2>
<hr/>
<table>
    <tr>
        <td><h4>Performer</h4></td>
        <td><h4>||</h4></td>
        <td><h4>Creating Date</h4></td>
        <td><h4>||</h4></td>
        <td><h4>Activity</h4></td>
    </tr>
    <c:forEach var="rep" items="${report}">
        <tr>
            <td>${rep.performer}</td>
            <td>||</td>
            <td>${rep.creatingDate}</td>
            <td>||</td>
            <td>${rep.activity}</td>
        </tr>
    </c:forEach>
</table>
<hr/>
<br/>
<form action="DaoController" method="GET">
    <input type="submit" value="Start Page"/>
</form>
</body>
</html>
