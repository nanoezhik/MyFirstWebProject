<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Creating form</title>
</head>
<body>
<br/>
<h2>Creating a list of reports:</h2>
<hr/>
<form action="DaoController" method="POST">
    <table>
        <tr>
            <td>StartDate:</td>
            <td><input type="text" name="startDate"/></td>
        </tr>
        <tr>
            <td>EndDate:</td>
            <td><input type="text" name="endDate"/></td>
        </tr>
        <tr>
            <td>Performer:</td>
            <td>
                <select name="performer">
                <option>All Performers</option>
                    <c:forEach var="per" items="${perfs}">
                        <option>${per}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Time Period:</td>
            <td>
                <select name="period">
                    <option>   </option>
                    <option>Last Qtr</option>
                    <option>Last Month</option>
                    <option>Last Calendar Year</option>
                    <option>Current Year to Date</option>
                    <option>Current Qtr to Date</option>
                    <option>Current Month to Date</option>
                </select>
            </td>
        </tr>
    </table>
    <hr/>
    <br/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>