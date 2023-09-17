<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %> 
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>

<html>
<head>
</head>
<body>
	<h1>
		<%-- <bean:write name="helloWorldForm" property="message" /> --%>
		<bean:write name="helloWorldForm" property="message" />
	</h1>
	
	 <bean:message key="titre.bonjour"/>  <bean:write name="loginForm" property="nomUtilisateur"/> 
</body>
</html>