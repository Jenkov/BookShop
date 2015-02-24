<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Administration Login</title>
		<meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
		<link href="/BookShop/css/stylesheet.css" type="text/css" rel="stylesheet">
        <s:head/>
	</head>
	<body>
		<div id="header"></div>
        <s:form name="frmAdminLogin" id="frmAdminLogin" method="post" action="doLogin" validate="true">
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
                    <td style="border-right:fuchsia 2px solid;">
                        <img src="/BookShop/images/BookShop.jpg" height="250"/>
                    </td>
					<td valign="middle">
                        <table align="center" cellspacing="0" cellpadding="4" border="0" width="248px">
                            <tr>
                                <td colspan="2" class="spanHeader">
                                    <span>Back Office</span>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="left" class="error">
                                    <s:property value="message" />
                                </td>
                            </tr>
                            <tr>
                                <td valign="middle">
                                     <s:textfield required="true" requiredposition="left" maxLength="25" label="Username" name="systemuser.Username" title="Enter Username"/>
                                     <s:password required="true" requiredposition="left" maxLength="8" label="Password" name="systemuser.Password" title="Enter Password"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <s:submit cssClass="buttonText" cssStyle="background:url(/BookShop/images/submit_bg.gif) no-repeat scroll 37px 0px;" name="login" value="Login" />
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </s:form>
        <s:include value="/common/footer.jsp" />
	</body>
</html>