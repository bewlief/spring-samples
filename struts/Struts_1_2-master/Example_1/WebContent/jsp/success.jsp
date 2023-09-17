<%@page import="com.sample.pojo.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display tag Pagination and Sorting Example in JSP</title>
<link rel="stylesheet" href="css/displaytag.css" type="text/css">
<link rel="stylesheet" href="css/screen.css" type="text/css">
<link rel="stylesheet" href="css/site.css" type="text/css">
<style type="text/css">
</style>
</head>
<body>
	<select multiple="multiple" name="prodSKUs">
		<c:forEach items="${productSubCategoryList}"
			var="productSubCategoryList">
			<option value="${productSubCategoryList}"
				${not empty productSubCategoryMap[productSubCategoryList] ? 'selected' : ''}>${productSubCategoryList}</option>
		</c:forEach>
	</select>

	<div id='tab1' class="tab_content" style="display: block; width: 100%">
		<h3>Display Tag Example</h3>
		<p>This is FIRST TABLE</p>
		<display:table name="sessionScope.players" pagesize="5" export="true"
			sort="list" uid="one">
			<%int j=0; %>
			<display:column property="name" title="Name" sortable="true"
				headerClass="sortable" style="odd" />
			<display:column property="contact" title="Mobile" sortable="true"
				headerClass="sortable" style="even" />
			<display:column property="city" title="Resident" sortable="true"
				headerClass="sortable" style="odd" />
			<display:column>
				<select name="s" id="s_<%=j%>">
					<c:forEach var="i" begin="1" end="5">
						<option value="${i }" ${(i-j)==0 ?'selected':'' } >${i}</option>
						<%j++; 
						System.out.println(j);
						%>
						<bean:write name="players" property="contact" scope="session"/>
					</c:forEach>
				</select>
			</display:column>
			
			<!-- <option value="${productSubCategoryList}"
			${productSubCategoryList == productSubCategoryName ? 'selected' : ''}>
			${productSubCategoryList}</option>-->
		</display:table>
	</div>

	<div id='tab2' class="tab_content" style="width: 100%">
		<h3>Table 2</h3>
		<p>This is SECOND TABLE</p>
		<display:table name="sessionScope.stars" pagesize="5" export="false"
			sort="list" uid="two">
			<display:column property="name" title="Name" sortable="true"
				headerClass="sortable" />
			<display:column property="contact" title="Mobile" sortable="true"
				headerClass="sortable" />
			<display:column property="city" title="Resident" sortable="true"
				headerClass="sortable" />
		</display:table>
	</div>
</body>
<script type="text/javascript">
	function SelectElement(valueToSelect) {
		var element = document.getElementById('leaveCode');
		element.value = valueToSelect;
	}
</script>
</html>

