<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="recordBean" class="org.sbx.model.Record" scope="session">
  <jsp:setProperty name="recordBean" property="*" />
</jsp:useBean>
<jsp:forward page="/add-data" />
