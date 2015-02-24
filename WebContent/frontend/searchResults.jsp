<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Search</title>
		<meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
		<link href="/BookShop/css/stylesheet.css" type="text/css" rel="stylesheet">
        <s:head theme="ajax"/>
    </head>
    <body>
        <div id="header">
            <s:include value="userHeader.jsp" />
        </div>
        <s:form id="frmSearch" name="frmSearch" method="post">
            <table border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
                <tr>
                    <td align="center">
						<span style="font:16px/18px Georgia, serif; width:450px; color:#990000; height:37px;">Search for books, authors or publishers by keywords</span>
                    </td>
                </tr>
                <tr><td>&nbsp;</td></tr>
                <tr>
                    <td align="center">
                        <table border="0" align="center" width="100%" cellpadding="0" cellspacing="0">
                            <s:textfield id="Search" name="SearchCriteria" title="Enter the search criteria" maxLength="80" size="100"/>
                        </table>
                    </td>
                </tr>
                <tr><td>&nbsp;</td></tr>
                <tr>
                    <td align="center">
                        <table border="0" align="center" width="100%" cellpadding="0" cellspacing="0">
                            <s:submit action="showBooksSearchResults" theme="simple" cssStyle="background:url(/BookShop/images/submit_bg.gif) no-repeat scroll 33px 0px;" cssClass="buttonText" name="Book" id="Book" value="Book" />
                            <s:submit action="showAuthorsSearchResults" theme="simple" cssStyle="background:url(/BookShop/images/submit_bg.gif) no-repeat scroll 40px 0px;" cssClass="buttonText" name="Author" id="Author" value="Author" />
                            <s:submit action="showPublishersSearchResults" theme="simple" cssStyle="background:url(/BookShop/images/submit_bg.gif) no-repeat scroll 43px 0px;" cssClass="buttonText" name="Publisher" id="Publisher" value="Publisher" />
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>
                        <table border="0" width="100%" align="center" cellspacing="0" cellpadding="0">
                            <tr>
                                <td width="20%">
                                    <s:iterator value="books" id="books">
                                        <table cellpadding="0" cellspacing="0" width="100%">
                                            <tr>
                                                <td>
                                                    <fieldset>
                                                        <legend class="Arial13BrownB"><s:property value="BookName"/></legend>
                                                        <table border="0" width="100%" cellspacing="2" cellpadding="0">
                                                            <tr>
                                                                <td valign="top" align="left" width="15%" colspan="2" class="Arial13GrayN">
                                                                    <a href='<s:url action='showBookDetails'><s:param name='book.BookNo' value='BookNo' /></s:url>'>
                                                                        <img src="getFile.action?columnName=CoverPage&tableName=Books&whereClause=BookNo&whereClauseValue=<s:property value="BookNo" />" width="100px"/>
                                                                    </a>
                                                                </td>
                                                                <td align="left" width="85%" valign="top">
                                                                    <table border="0" width="100%" cellpadding="0" cellspacing="2" align="left">
                                                                        <tr>
                                                                            <td valign="top" width="22%" align="right" class="mandatory">Synopsis:&nbsp;</td>
                                                                            <td width="78%" valign="top" class="Arial13GrayN"><s:property value="Synopsis"/></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td valign="top" width="22%" align="right" class="mandatory">About Authors:&nbsp;</td>
                                                                            <td valign="top" width="78%" class="Arial13GrayN"><s:property value="AboutAuthors"/></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td valign="top" width="22%" align="right" class="mandatory">ISBN:&nbsp;</td>
                                                                            <td valign="top" width="78%" class="Arial13GrayN"><s:property value="ISBN"/></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td valign="top" width="22%" align="right" class="mandatory">Cost:&nbsp;</td>
                                                                            <td valign="top" width="78%" class="Arial13GrayN"><s:property value="Cost"/></td>
                                                                        </tr>
                                                                    </table>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </fieldset>
                                                </td>
                                            </tr>
                                        </table>
                                    </s:iterator>
                                    <s:iterator value="authors" id="authors">
                                        <table cellpadding="0" cellspacing="0" width="100%">
                                            <tr>
                                                <td>
                                                    <fieldset>
                                                        <legend class="Arial13BrownB"><s:property value="FirstName"/> <s:property value="LastName"/></legend>
                                                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                            <tr>
                                                                <td valign="top" align="left" width="15%" class="Arail13GrayN">
                                                                    <a href='<s:url action='showAuthorDetails'><s:param name='author.AuthorNo' value='AuthorNo' /></s:url>'>
                                                                        <img src="getFile.action?columnName=Photograph&tableName=Authors&whereClause=AuthorNo&whereClauseValue=<s:property value="AuthorNo" />" width="120px"/>
                                                                    </a>
                                                                </td>
                                                                <td align="left" valign="top" width="85%">
                                                                    <table width="100%" border="0" cellpadding="0" cellspacing="2" align="left">
                                                                        <tr>
                                                                            <td valign="top" width="22%" align="right" class="mandatory">Email Address:&nbsp;</td>
                                                                            <td valign="top" width="78%" class="Arial13GrayN"><s:property value="EmailAddress"/></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td valign="top" width="22%" align="right" class="mandatory">Speciality:&nbsp;</td>
                                                                            <td valign="top" width="78%" class="Arial13GrayN"><s:property value="Speciality"/></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td valign="top" width="22%" align="right" class="mandatory">Books authored:&nbsp;</td>
                                                                            <td valign="top" width="78%" class="Arial13GrayN">
                                                                                <s:action name="showBooksOfThisAuthor" executeResult="false" id="booksVal">
                                                                                    <s:param name="author.AuthorNo">
                                                                                        <s:property value="AuthorNo"/>
                                                                                    </s:param>
                                                                                </s:action>
                                                                                <s:iterator value="#booksVal.authoredBooks" id="authoredBooks">
                                                                                    <a href='<s:url action='showBookDetails'><s:param name='book.BookNo' value='BookNo' /></s:url>'><s:property value="BookName"/></a><br>
                                                                                </s:iterator>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </fieldset>
                                                </td>
                                            </tr>
                                        </table>
                                    </s:iterator>
                                    <s:iterator value="publishers" id="publishers">
                                        <table cellpadding="0" cellspacing="0" width="100%">
                                            <tr>
                                                <td>
                                                    <fieldset>
                                                        <legend class="Arial13BrownB"><s:property value="PublisherName"/></legend>
                                                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                            <tr>
                                                                <td align="left" valign="top" width="85%">
                                                                    <table width="100%" border="0" cellpadding="0" cellspacing="2" align="left">
                                                                        <tr>
                                                                            <td valign="top" width="22%" align="right" class="mandatory">Email Address:&nbsp;</td>
                                                                            <td valign="top" width="78%" class="Arial13GrayN"><s:property value="EmailAddress"/></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td valign="top" width="22%" align="right" class="mandatory">Books published:&nbsp;</td>
                                                                            <td valign="top" width="78%" class="Arial13GrayN">
                                                                                <s:action name="showBooksOfThisPublisher" executeResult="false" id="booksVal">
                                                                                    <s:param name="publisher.PublisherNo">
                                                                                        <s:property value="PublisherNo"/>
                                                                                    </s:param>
                                                                                </s:action>
                                                                                <s:iterator value="#booksVal.publishedBooks" id="publishedBooks">
                                                                                    <a href='<s:url action='showBookDetails'><s:param name='book.BookNo' value='BookNo' /></s:url>'><s:property value="BookName"/></a><br>
                                                                                </s:iterator>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </fieldset>
                                                </td>
                                            </tr>
                                        </table>
                                    </s:iterator>
                                    <s:if test="#books==null && #authors==null && #publishers==null">
                                        <span style="font:16px/18px Georgia, serif; width:300px; color:#990000; height:37px;">Currently there are no search results.<br><br>To search follow the suggestions like:<ul><li>make sure all words are spelled correctly</li><li>try different keywords</li><li>try more general keywords.</li></ul></span>
                                    </s:if>
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