<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
		<title>Double Post Error</title>
		<meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
		<link href="/BookShop/css/stylesheet.css" type="text/css" rel="stylesheet">
        <s:head />
    </head>
    <body>
		<div id="header">
			<s:include value="header.jsp" />
		</div>
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
                    <td valign="top">
                        <img src="/BookShop/images/leftImg.jpg" height="350"/>
                    </td>
					<td valign="top">
                        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                                <td class="treb13blacknormal">
                                    There was a double post while intercepting this request. Therefore, this request has be prevented from executing again.
                                </td>
                            </tr>
                            <tr>
                                <td class="treb13blacknormal">
                                    <br><br>
                                    Click here to return to <s:url id="back" value="/"/><s:a href="admin/adminHome.jsp">Admin Homepage</s:a>.
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        <s:include value="/common/footer.jsp" />
    </body>
</html>