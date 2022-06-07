<%--
  Created by IntelliJ IDEA.
  User: azizbek
  Date: 07.06.2022
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ReadPage</title>
    <p><strong>Class List is Here | <a href="createClass.jsp">Click for Create</a></strong></p>
    <table border="1">
        <tr>
            <th>Class_name</th>

        </tr>
        <c:forEach var="ketmon" items="${classList}">
            <tr>
              <td>${ketmon.id}</td>
                <td>${ketmon.class_name}</td>


                <td><a href="update/<c:out value='${ketmon.id}'/>">Update</a> | <a
                        href="delete/<c:out value='${ketmon.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</head>
<body>

</body>
</html>
