<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html"; charset="utf-8">
      <link rel="stylesheet" href="css/style.css">
    <title>Show records</title>
</head>
<body>
  <header class="header">
    <div id="headerInner">
      <nav class="topMenu">
        <ul>
          <li><a href="index.jsp">Главная</a></li>
          <li><a href="add_new_record.jsp">Новая запись</a></li>
          <li><a href="load-data">Просмотр записей</a></li>
        </ul>
      </nav>
      <div id="loginFormBlock">
        <form id="loginForm" action="/login">
          <label for="userForm">Login: </label><input id="userForm" type="edit" name="userForm" />
          <label for="passForm">Password: </label><input id="passForm" type="password" name="passForm" />
        </form>
      </div>
    </div>
  </header>
  <div id="wrapper">
    <div id="middle">
      <div id="content">
        <div id="colLeft">
          <table>
            <c:forEach items="${recordList}" var="record">
              <tr>
                <td>#${record.id}</td>
                <td>${record.title}</td>
                <td>${record.author}</td>
                <td>${record.date}</td>
              </tr>
              <tr>
                <td colspan="4">${record.body}</td>
              </tr>
            </c:forEach>
          </table>
        </div> <!-- colLeft end -->

        <aside id="colRight">

        </aside> <!-- colRight end -->

      </div> <!-- content end -->
    </div> <!-- middle end -->
  </div>
</body>
</html>
