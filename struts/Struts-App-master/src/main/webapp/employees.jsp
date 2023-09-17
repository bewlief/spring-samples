<%@ taglib uri="/WEB-INF/struts-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic" prefix="logic" %>

<html:html>
    <head>
        <title>Department Wise Employees</title>
    </head>
    <body>
    <logic:notEmpty name="departmentForm" property="employees">
        <table border="1">
            <thead>
                <tr>
                    <td>Id</td>
                    <td>Name</td>
                    <td>Code</td>
                    <td>Salary</td>
                    <td>Designation</td>
                    <td>Hiring Date</td>
                    <td>Department Code</td>
                    <td>Department Name</td>
                    <td>Address</td>
                </tr>
            </thead>
            <logic:iterate id="employee" name="departmentForm" property="employees" indexId="index">
                <tr>
                    <td><bean:write name="employee" property="id" /></td>
                    <td><bean:write name="employee" property="name" /></td>
                    <td><bean:write name="employee" property="employeeCode"/></td>
                    <td><bean:write name="employee" property="salary"/></td>
                    <td><bean:write name="employee" property="designation"/></td>
                    <td><bean:write name="employee" property="formattedHiringDate"/></td>
                    <td><bean:write name="employee" property="department.deptCode"/></td>
                    <td><bean:write name="employee" property="department.deptName"/></td>
                    <td><bean:write name="employee" property="department.address"/></td>
                </tr>
                <html:hidden property="id" name="employee" indexed="true"/>
            </logic:iterate>
        </table>
    </logic:notEmpty>
    </body>
</html:html>