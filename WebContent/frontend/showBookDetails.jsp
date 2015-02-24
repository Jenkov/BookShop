<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:property value="book.BookName"/></title>
		<link href="/BookShop/css/stylesheet.css" type="text/css" rel="stylesheet">
        <s:head />
    </head>
    <body>
        <div id="header">
            <s:include value="userHeader.jsp" />
        </div>
        <table border="0" width="100%" cellspacing="4" cellpadding="1">
            <tr>
                <td colspan="2" align="left" valign="top">
                    <span style="font:28px/30px Georgia, serif; width:300px; color:#990000; height:37px;"><s:property value="book.BookName"/></span>
                </td>
            </tr>
            <tr>
                <td align="left" valign="top">
                    <img src="getFile.action?columnName=CoverPage&tableName=Books&whereClause=BookNo&whereClauseValue=<s:property value="book.BookNo" />" width="100px"/>
                </td>
                <td align="center">
                    <s:if test="#session.username!=null">
                        <a href="<s:url action="addToCart"><s:param name="BookNo"><s:property value="book.BookNo"/></s:param><s:param name="BookName"><s:property value="book.BookName"/></s:param><s:param name="Cost"><s:property value="book.Cost"/></s:param></s:url>">
                            <img src="/BookShop/images/addToCart.jpg" width="74px" height="74px" style="cursor:pointer;" border="0"/>
                        </a>
                    </s:if>
                </td>
            </tr>
            <tr>
                <td align="left" class="Arial13GrayN" colspan="2"><s:property value="book.Synopsis" /></td>
            </tr>
            <tr><td colspan="2">&nbsp;</td></tr>
            <tr>
                <td align="left" colspan="2">
                    <table border="0" cellspacing="2" cellpadding="0" width="100%" style="border:1px dashed #0099ff;">
                        <tr>
                            <td class="Arial13BrownB" width="10%" align="left" style="border-bottom:1px dashed #0099ff; border-right:1px dashed #0099ff;">ISBN:&nbsp;</td>
                            <td valign="top" class="Arial13GrayN" colspan="2" width="80%" style="border-bottom:1px dashed #0099ff;"><s:property value="book.ISBN"/></td>
                        </tr>
                        <tr>
                            <td class="Arial13BrownB" width="10%" align="left" style="border-right:1px dashed #0099ff;">Edition:&nbsp;</td>
                            <td valign="top" class="Arial13GrayN" colspan="2" width="80%"><s:property value="book.Edition"/></td>
                        </tr>
                    </table>
                    <br>
                    <s:if test="#session.username!=null">`
                        <table border="0" cellspacing="2" cellpadding="0" width="100%" style="border:1px dashed #0099ff;">
                            <tr>
                                <td class="Arial13BrownB" colspan="3" width="20%" align="center" style="border-bottom:1px dashed #0099ff;">Downloads</td>
                            </tr>
                            <tr>
                                <td valign="top" colspan="2" class="Arial13GrayN" width="50%" align="center" style="border-right:1px dashed #0099ff;">
                                    <a href="getFile.action?columnName=Toc&tableName=Books&whereClause=BookNo&whereClauseValue=<s:property value="book.BookNo" />">Toc</a>
                                </td>
                                <td valign="top" class="Arial13GrayN" width="50%" align="center">
                                    <a href="getFile.action?columnName=SampleChapter&tableName=Books&whereClause=BookNo&whereClauseValue=<s:property value="book.BookNo" />">Sample Chapter</a>
                                </td>
                            </tr>
                        </table>
                    </s:if>
                </td>
            </tr>
            <tr><td colspan="2">&nbsp;</td></tr>
            <tr>
                <td colspan="2">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
                        <tr>
                            <td class="Arial13BrownB" align="left">About Author(s)</td>
                        </tr>
                        <tr>
                            <td class="Arial13GrayN" align="left"><s:property value="book.AboutAuthors"/></td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr><td colspan="2">&nbsp;</td></tr>
            <tr>
                <td colspan="2">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
                        <tr>
                            <td class="Arial13BrownB" align="left">Topics Covered</td>
                        </tr>
                        <tr>
                            <td class="Arial13GrayN" align="left"><s:property value="book.TopicsCovered"/></td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr><td colspan="2">&nbsp;</td></tr>
            <tr>
                <td colspan="2">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
                        <tr>
                            <td class="Arial13BrownB" align="left">Contents Of The CDROM</td>
                        </tr>
                        <tr>
                            <td class="Arial13GrayN" align="left"><s:property value="book.ContentsCDROM"/></td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
		<s:include value="/common/footer.jsp" />
    </body>
</html>