<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<html:html>
<head>
 <title><bean:message key="titre.creation.elementcourses"/></title>
</head>
<body>
<!-- Html errors -->
<b><i> <html:errors/> </i></b>
<!-- Form -->
<html:form action="/page/CreerCreationElementCourses.do">
 <bean:message key="creation.elementcourses.libelle.libelle"/> 
 <nested:text property="libelle"/><br>
 <bean:message key="creation.elementcourses.libelle.quantite"/>
 <nested:text property="quantite"/><br> 
  <html:submit/>
</html:form>
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