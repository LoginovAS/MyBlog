<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html"; charset="utf-8">
      <link rel="stylesheet" href="css/style.css">
    <title>Add data</title>
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
          <div class="newRecordForm">
            <c:out value="${message}" />
            <form method="post" action="add-data">
              <label class="recordFormLabel" for="recordTitle">Title: </label><input class="recordForm" id="recordTitle" type="text" name="recordTitle"/><br/><br/>
              <label class="recordFormLabel" for="recordAuthor">Author: </label><input class="recordForm" id="recordAuthor" type="text" name="recordAuthor"/><br/><br/>
              <label class="recordFormLabel" for="recordText">Text: </label><textarea class="recordForm" id="recordText" name="recordText" rows="10"></textarea><br/>
              <input type="submit" value="Send" />
            </form>
          </div>
        </div> <!-- colLeft end -->

        <aside id="colRight">

        </aside> <!-- colRight end -->

      </div> <!-- content end -->
    </div> <!-- middle end -->
  </div>
</body>
</html>
