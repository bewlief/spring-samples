<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
    <%@taglib uri="http://struts.apache.org/tags-html"  prefix="html" %>
  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
viewUser



<bean:write name="u" property="phone"/>

<bean:write name="u" property="name"/>

</body>
</html>