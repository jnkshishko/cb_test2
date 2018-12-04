<%--
  Created by IntelliJ IDEA.
  User: Eugenio
  Date: 03.12.2018
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="gosnumber" value="${param.gosnumber}"/>
<c:set var="type" value="${param.type}"/>
<c:set var="cost" value="${param.cost}"/>
<html>
<head>
    <style>
        table {
            border-collapse: collapse;
        }
        td, th {
            padding: 3px;
            border: 1px solid black;
        }
    </style>
    <title>Детали штрафа</title>
</head>
<body>
<h1>Детали штрафа</h1>
    <div>
        <table>
            <tr>
                <td>Гос.номер</td>
                <td>Тип штрафа</td>
                <td>Стоимость</td>
            </tr>
            <tr>
                <td>${gosnumber}</td>
                <td>${type}</td>
                <td>${cost}</td>
            </tr>
            <button onclick="location.href='index.jsp'">Назад</button>
        </table>
    </div>
</body>
</html>
