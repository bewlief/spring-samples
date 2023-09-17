<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<title><bean:message key="titre.login" /></title>
<html:base />
</head>
<body bgcolor="white">
	<html:form action="loginForm" focus="nomUtilisateur">
	Test
		<%-- <table border="0" align="center">
			<tr>
				<td align="right"><<bean:message key="user.username"/></td>
				<td align="left"><html:text property="nomUtilisateur" size="20"
						maxlength="20" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="user.password"/> </td>
				<td align="left"><html:password property="mdpUtilisateur"
						size="20" maxlength="20" redisplay="false" /></td>
			</tr>
			<tr>
				<td align="right"><html:submit property="submit" value="button.login" />
				</td>
				<td align="left"><html:reset /></td>
			</tr>
		</table> --%>
	</html:form>
</body>
</html:html>