<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Manage Transactions</title>
		<meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
		<link href="/BookShop/css/stylesheet.css" type="text/css" rel="stylesheet">
        <s:head/>
    </head>
	<body>
		<div id="header">
			<s:include value="header.jsp" />
		</div>
		<s:form id="frmTransactions" name="frmTransactions" method="post" action="doViewTransactions" validate="true">
            <s:token/>
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
                    <td valign="top" width="25%">
                        <img src="/BookShop/images/leftImg.jpg" height="350"/>
                    </td>
					<td valign="top">
                        <table border="0" cellpadding="0" cellspacing="0" align="center" width="100%">
                            <tr>
                                <td>
                                    <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                        <tr>
                                            <td valign="top" align="left" class="spanHeader">
                                                <span>Manage Transactions</span>
                                            </td>
                                            <td class="treb13blacknormal" valign="top" align="right">&nbsp;</td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr align="left" valign="top">
                                <td height="20" style="background:url('/BookShop/images/hr.jpg') repeat-x;">&nbsp;</td>
                            </tr>
                            <tr align="left" valign="top">
                                <td>
                                    <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                                    <s:select label="Username" name="Username" id="Username" required="true" requiredposition="true" list="ddlbUsernames" listKey="Username" listValue="Username" headerKey="" headerValue="Select Username"></s:select>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <br /><br />
                                                <s:submit theme="simple" cssStyle="background:url(/BookShop/images/submit_bg.gif) no-repeat scroll 37px 0px;" cssClass="buttonText" name="btnSubmit" id="btnSubmit" value="Search" />
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr align="left" valign="top">
                                <td height="20" style="background:url('/BookShop/images/hr.jpg') repeat-x;">&nbsp;</td>
                            </tr>
                            <tr>
                                <td>
                                    <br />
                                    <table class="view" align="center" cellspacing="0" cellpadding="0" width="100%">
                                        <s:iterator value="transactions" id="transactions" status="stat">
                                            <s:if test="#stat.index == 0">
                                                <tr>
                                                    <th width="8%" class="Arial13BrownB" align="left">&nbsp;</th>
                                                    <th width="10%" class="Arial13BrownB" align="left">Date</th>
                                                    <th width="70%" class="Arial13BrownB" align="left">Book Name</th>
                                                    <th width="12%" class="Arial13BrownB" align="left">Amount</th>
                                                </tr>
                                            </s:if>
                                            <tr class="<s:if test="#stat.odd == true">odd</s:if><s:else>even</s:else>">
                                                <td width="8%" valign="top" align="left">
                                                    <s:property value="TransactionNo"/>
                                                </td>
                                                <td width="10%" valign="top" align="left">
                                                    <s:property value="TransactionDate"/>
                                                </td>
                                                <td width="70%" valign="top" align="left">
                                                    <s:property value="BookName" />
                                                </td>
                                                <td width="12%" valign="top" align="left">
                                                    <s:property value="Cost" />
                                                </td>
                                            </tr>
                                        </s:iterator>
                                        <s:if test="#transactions==null">
                                            <span style="font:16px/18px Georgia, serif; width:300px; color:#990000; height:37px;">Currently there no transactions available. To see the transaction details select the username.</span>
                                        </s:if>
                                    </table>
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