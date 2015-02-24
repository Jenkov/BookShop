<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:property value="publisher.PublisherName"/>'s Profile</title>
		<link href="/BookShop/css/stylesheet.css" type="text/css" rel="stylesheet">
        <s:head />
    </head>
    <body>
        <div id="header">
            <s:include value="userHeader.jsp" />
        </div>
        <table width="100%" border="0" cellspacing="4" cellpadding="1">
            <tr>
                <td align="left" valign="top">
                    <span style="font:30px/32px Georgia,serif; width:300px; color:#990000; height:37px;"><s:property value="publisher.PublisherName"/></span>
                </td>
            </tr>
            <tr><td>&nbsp;</td></tr>
            <tr>
                <td align="left" valign="top">
                    <table cellspacing="0" border="0" cellpadding="4" width="100%" style="border:1px dashed #0099ff;">
                        <tr>
                            <td class="Arial13BrownB" width="20%" align="left" style="border-right:1px dashed #0099ff;">
                                Email Address:&nbsp;
                            </td>
                            <td class="Arial13grayN" valign="top" width="80%">
                                <a href='mailto:<s:property value="publisher.EmailAddress"/>'>
                                    <s:property value="publisher.EmailAddress" />
                                </a>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
				<td>
                    <br>
					<span style="font:16px/18px Georgia, serif; text-align:center; width:300px; color:#990000; height:37px;">Books published by <s:property value="publisher.PublisherName"/></span>
					<br><br>
					<table class="view" align="center" cellspacing="0" cellpadding="6" width="100%">
						<tr>
                            <th width="20%" class="Arial13BrownB" align="left">Book</th>
                            <th width="60%" class="Arial13BrownB" align="left">Synopsis</th>
                            <th width="10%" class="Arial13BrownB" align="left">Cover Page</th>
                            <s:if test="#session.username!=null">
                                <th width="10%" class="Arial13BrownB" align="left">&nbsp;</th>
                            </s:if>
                        </tr>
                        <s:iterator value="books">
                            <tr title="Click to view">
                                <td width="20%" valign="top" align="left" style="cursor:pointer;" onclick="javascript:location.href='<s:url action='showBookDetails'><s:param name='book.BookNo' value='BookNo' /></s:url>'">
                                    <s:property value="BookName"/>
                                </td>
                                <td width="60%" valign="top" align="left" style="cursor:pointer;" onclick="javascript:location.href='<s:url action='showBookDetails'><s:param name='book.BookNo' value='BookNo' /></s:url>'">
                                    <s:property value="Synopsis"/>
                                </td>
                                <td width="10%" valign="top" align="left" style="cursor:pointer;" onclick="javascript:location.href='<s:url action='showBookDetails'><s:param name='book.BookNo' value='BookNo' /></s:url>'">
                                    <img src="getFile.action?columnName=CoverPage&tableName=Books&whereClause=BookNo&whereClauseValue=<s:property value="BookNo" />" width="80px"/>
                                </td>
                                <s:if test="#session.username!=null">
                                    <td width="10%" valign="top" align="left" style="cursor:pointer;">
                                        <a href="<s:url action="addToCart"><s:param name="BookNo"><s:property value="BookNo"/></s:param><s:param name="BookName"><s:property value="BookName"/></s:param><s:param name="Cost"><s:property value="Cost"/></s:param></s:url>">
                                            <img src="/BookShop/images/addToCart.jpg" width="74px" height="74px" style="cursor:pointer;" border="0"/>
                                        </a>
                                    </td>
                                </s:if>
                            </tr>
                        </s:iterator>
                    </table>
                </td>
            </tr>
        </table>
		<s:include value="/common/footer.jsp" />
    </body>
</html>