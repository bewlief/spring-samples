
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
</head>
<body>
<p style="color: red"><html:errors/></p>
	<html:form action="/user-view.html" method="post">
		<p>
			<bean:message key="user.name" />
		</p>
		<html:text property="name" name="user"></html:text>
		<p>
			<bean:message key="user.age" />
		</p>
		<html:text property="age" name="user"></html:text>
		<p>
			<bean:message key="user.sex" />
		</p>
		<html:radio property="sex" name="user" value="nam">nam</html:radio>
		<html:radio property="sex" name="user" value="nu">nu</html:radio>
		<p>
			<bean:message key="user.name" />
		</p>
		<html:checkbox property="sothich" name="user" value="games">games</html:checkbox>
		<html:checkbox property="sothich" name="user" value="food">food</html:checkbox>
		<html:checkbox property="sothich" name="user">shopping</html:checkbox>
		<p>
			<bean:message key="user.name" />
		</p>
		<html:textarea property="about" name="user"></html:textarea>
		<p>
			<bean:message key="user.name" />
		</p>
		<html:select property="job" name="user">
			<html:option value="IT">IT</html:option>
			<html:option value="sex">sex</html:option>
			<html:option value="teacher">teacher</html:option>
		</html:select>
		<html:submit>them nguoi dung</html:submit>
	</html:form>
</body>
</html>