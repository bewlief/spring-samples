<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<html:html>
<head>
<title><bean:message key="titre.suppression.elementcourses"/></title>
</head>
<body>
	<html:form action="/page/SupprimerSuppressionElementCourses.do">
		<nested:hidden styleId="id" property="id" />
		<table border="1">
			<thead>
				<tr>
					<th><bean:message key="colonne.identifiant" /></th>
					<th><bean:message key="colonne.libelle" /></th>
					<th><bean:message key="colonne.quantite" /></th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<logic:iterate id="elementCourse" name="LISTE_COURSES"
					type="com.adservio.tutu.entity.ElementCourseBean">
					<tr>
						<bean:define id="id" name="elementCourse" property="id" />
						<td><bean:write name="elementCourse" property="id" /></td>
						<td><bean:write name="elementCourse" property="libelle" /></td>
						<td><bean:write name="elementCourse" property="quantite" /></td>
						<td><a href="#"
							onclick="document.getElementById('id').value = ${id}; document.forms[0].submit();">
								<bean:message key="button.delete" />
						</a></td>
					</tr>
				</logic:iterate>
			</tbody>
		</table>
	</html:form>
</body>
</html:html>