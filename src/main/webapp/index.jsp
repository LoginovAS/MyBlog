<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html"; charset="utf-8">
    <title>Add data</title>
</head>
<body>
  <form method="post" action="forwarder.jsp">
    <label for="recordTitle">Title: </label><input id="recordTitle" type="edit" name="recordTitle" /><br/>
    <label for="recordText">Text: </label><input id="recordText" type="textarea" name="recordText" /><br/>
    <input type="submit" value="Send" />
  </form>
</body>
</html>
