<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %> 
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<html:html locale="true">
  <head>
    <title>Accueil</title>
    <html:base/>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  </head>
  <body bgcolor="white">
     <h1> Bienvenue <bean:write name="loginForm" property="nomUtilisateur"/></h1>
  </body>
</html:html>