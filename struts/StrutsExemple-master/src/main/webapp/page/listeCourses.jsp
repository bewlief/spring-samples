<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bean:message key="titre.listcrourses" /></title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th><bean:message key="colonne.id" /></th>
				<th><bean:message key="colonne.libelle" /></th>
				<th><bean:message key="colonne.quantite" /></th>
			</tr>
		</thead>
		<tbody>
			<logic:iterate id="elementCourse" name="LISTE_COURSES"
				type="com.adservio.tutu.entity.ElementCourseBean">
				<tr>
					<th><bean:write name="elementCourse" property="id" /></th>
					<th><bean:write name="elementCourse" property="libelle" /></th>
					<th><bean:write name="elementCourse" property="quantite" /></th>
				</tr>
			</logic:iterate>
		</tbody>
	</table>
</body>
</html:html>
