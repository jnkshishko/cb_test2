<%--
  Created by IntelliJ IDEA.
  User: Eugenio
  Date: 30.11.2018
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <title>Информация о штрафах</title>
  </head>
  <body>
    <h1>Информация о штрафах</h1>
    <div>
        <form action="search" method="post">
            <label>Гос. номер:
                <input type="text" name="gosnumber" style="position: absolute; left: 190px;"><br/>
            </label>
            <label>Владелец (ФИО):
                <input type="text" name="fullName" style="position: absolute; left: 190px;"><br/>
            </label>

            <button type="submit">Искать</button>
        </form>
    </div>
    <div>
        <table>
            <tr>
                <td>Гос.номер</td>
                <td>Марка</td>
                <td>Модель</td>
                <td>Фамилия</td>
                <td>Имя</td>
                <td>Отчество</td>
                <td></td>
            </tr>
            <c:forEach items="${answers}" var="answer">
            <tr>
                <td>${answer.gosnumber}</td>
                <td>${answer.mark}</td>
                <td>${answer.model}</td>
                <td>${answer.ownerLastname}</td>
                <td>${answer.ownerFirstname}</td>
                <td>${answer.ownerMiddlename}</td>

                <td><a href="details.jsp?gosnumber=${answer.gosnumber}&&type=${answer.typeOfFine}&&cost=${answer.costOfFine}">Детали штрафа</a> </td>
            </tr>
            </c:forEach>
        </table>
        <button onclick="location.href='report'">Отчет</button>
    </div>
  </body>
</html>
