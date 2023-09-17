<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<html:html>
<head>
<title></title>
</head>
<body>
	This is the error :
	<bean:message key="titre.erreur" />
	<html:errors />
	<br />
</body>
</html:html>
