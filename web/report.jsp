<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Eugenio
  Date: 03.12.2018
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>Отчет</title>
</head>
<body>
<h1>Пять самых частых штрафов</h1>
    <div>
        <table>
            <tr>
                <td>Количество</td>
                <td>Тип штрафа</td>
                <td>Стоимость</td>
            </tr>
            <c:forEach items="${list}" var="report">
                <tr>
                    <td>${report.count}</td>
                    <td>${report.type}</td>
                    <td>${report.cost}</td>
                </tr>
            </c:forEach>
            <button onclick="location.href='index.jsp'">Назад</button>
        </table>
    </div>
</body>
</html>
