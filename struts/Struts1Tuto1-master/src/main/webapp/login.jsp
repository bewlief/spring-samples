<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<html>
<head>
</head>
<body>
<h1>Struts html:text example</h1>

<html:form action="/Login">

    <div style="color:red">
        <html:errors/>
    </div><!--

    <html:messages id="err_name" property="common.name.err">
        <div style="color:red">
        <bean:write name="err_name" />
        </div>
    </html:messages>

    --><div style="padding:16px">
    <div style="float:left;padding-right:8px;">
        <bean:message key="label.common.name" /> :
    </div>

    <html:text property="userName" size="20" maxlength="20"/>
    </div>

    <div style="padding:16px">
        <div style="float:left;padding-right:8px;">
            <html:submit><bean:message key="label.common.button.submit" /></html:submit>
        </div>
        <html:reset><bean:message key="label.common.button.reset" /></html:reset>
    </div>

</html:form>


</body>
</html>