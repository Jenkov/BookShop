<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Forgot Password</title>
        <meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
		<link href="/BookShop/css/stylesheet.css" type="text/css" rel="stylesheet">
        <s:head theme="ajax"/>
    </head>
    <body>
        <div id="header">
            <s:include value="userHeader.jsp" />
        </div>
        <s:form name="frmForgotPassword" method="post" action="doRetrievePassword">
			<table border="0" cellspacing="0" cellpadding="2" align="center">
				<tr>
					<td colspan="2">
						<span style="padding-left:55px; padding-bottom:10px; font:24px/30px Georgia, serif; width:228px; color:#786e4e; height:37px;">Forgot Password</span>
					</td>
				</tr>
				<tr><td colspan="2">&nbsp;</td></tr>
				<tr>
					<td colspan="2" class="treb13blacknormal" valign="top" align="right">
						It is mandatory to enter information in all information <br>capture boxes which have a <span class="mandatory">*</span> adjacent
					</td>
				</tr>
				<tr>
                    <td colspan="2" class="error">
                        <s:property value="message" />
                    </td>
                </tr>
                <s:textfield required="true" requiredposition="left" maxLength="50" label="Email Address" name="customer.EmailAddress" title="Enter email address"/>
                <s:textfield required="true" requiredposition="left" maxLength="25" label="Username" name="customer.Username" title="Enter Username"/>
				<tr>
					<td valign="top" align="right">
                        <s:submit cssClass="buttonText" cssStyle="background:url(/BookShop/images/submit_bg.gif) no-repeat scroll 45px 0px;" name="SendPassword" value="Fetch" />
					</td>
				</tr>
			</table>
		</s:form>
        <s:include value="/common/footer.jsp" />
    </body>
</html>
