<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Registration Thank You</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="/BookShop/css/stylesheet.css" type="text/css" rel="stylesheet">
        <s:head theme="ajax"/>
    </head>
    <body>
        <div id="header">
            <s:include value="userHeader.jsp" />
        </div>
		<table border="0" cellspacing="0" cellpadding="2" align="center">
			<tr align="left" valign="top">
				<td height="20">
					<img src="/BookShop/images/hrLine.gif"/>
				</td>
			</tr>
			<tr>
				<td class="spanHeader">
					<span>Registration</span>
				</td>
			</tr>
			<tr>
				<td valign="top" align="center">
					Thank You for registering with <br>Sharanam's Bookshop. An email with <br>activation details has been sent to your <br>email address. Follow the instructions <br>given in email to activate your account.
				</td>
			</tr>
			<tr align="left" valign="top">
				<td height="20">
					<img src="/BookShop/images/hrLine.gif"/>
				</td>
			</tr>
		</table>
		<s:include value="/common/footer.jsp" />
    </body>
</html>