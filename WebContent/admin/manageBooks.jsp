<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Manage Books</title>
		<meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
		<link href="/BookShop/css/stylesheet.css" type="text/css" rel="stylesheet">
        <s:head/>
    </head>
	<body>
		<div id="header">
			<s:include value="header.jsp" />
		</div>
		<s:form action="doInsertBook" method="post" name="frmBooks" id="frmBooks" enctype="multipart/form-data" validate="true">
            <s:token/>
            <s:hidden name="book.BookNo" id="BookNo"/>
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
                    <td valign="top" width="25%">
                        <img src="/BookShop/images/leftImg.jpg" height="350"/>
                    </td>
					<td valign="top">
                        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                                <td>
                                    <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                        <tr>
                                            <td valign="top" align="left" class="spanHeader">
                                                <span>Manage Books</span>
                                            </td>
                                            <td class="treb13blacknormal" valign="top" align="right">
                                                It is mandatory to enter information in all information <br>capture boxes which have a <span class="mandatory">*</span> adjacent
                                            </td>
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
                                                    <tr>
                                                        <td class="Arial13BrownB">
                                                            <br />Book Details<br /><br />
                                                        </td>
                                                    </tr>
                                                    <s:textfield required="true" requiredposition="left" id="BookName" label="Book" name="book.BookName" title="Enter the book name" maxLength="25" size="55"/>
                                                    <s:select list="ddlb.ddlbPublishers" listKey="PublisherNo" listValue="PublisherName" headerKey="" headerValue="Select Publisher" required="true" requiredposition="left" id="PublisherName" label="Publisher" name="book.PublisherNo" title="Select the publisher name"></s:select>
                                                    <s:select list="ddlb.ddlbCategories" listKey="CategoryNo" listValue="Category" headerKey="" headerValue="Select Category" required="true" requiredposition="left" id="Category" label="Category" name="book.CategoryNo" title="Select the category name"></s:select>
                                                    <s:file id="CoverPage" name="CoverPage" label="Cover Page Image" title="Enter the path of the cover page image"></s:file>
                                                    <s:textfield required="true" requiredposition="left" id="ISBN" label="ISBN" name="book.ISBN" title="Enter the ISBN" maxLength="15" size="30"/>
                                                    <s:textfield required="true" requiredposition="left" id="Edition" label="Edition" name="book.Edition" title="Enter the edition of the book" maxLength="25" size="55"/>
                                                    <s:textfield required="true" requiredposition="left" id="Year" label="Year" name="book.Year" title="Enter the year" maxLength="4" size="4"/>
                                                    <s:textfield required="true" requiredposition="left" id="Cost" label="Cost" name="book.Cost" title="Enter the cost of the book" maxLength="8" size="8"/>
                                                    <tr>
                                                        <td class="Arial13BrownB">
                                                            <br />Author Details<br /><br />
                                                        </td>
                                                    </tr>
                                                    <s:select list="ddlb.ddlbAuthors" listKey="AuthorNo" listValue="FirstName + ' ' + LastName" headerKey="" headerValue="Select Author" required="true" requiredposition="left" id="FirstAuthor" label="First Author" name="book.Author1No" title="Select the name of the author"></s:select>
                                                    <s:select list="ddlb.ddlbAuthors" listKey="AuthorNo" listValue="FirstName + ' ' + LastName" headerKey="" headerValue="Select Author" id="SecondAuthor" label="Second Author" name="book.Author2No" title="Select the name of the author"></s:select>
                                                    <s:select list="ddlb.ddlbAuthors" listKey="AuthorNo" listValue="FirstName + ' ' + LastName" headerKey="" headerValue="Select Author" id="ThirdAuthor" label="Third Author" name="book.Author3No" title="Select the name of the author"></s:select>
                                                    <s:select list="ddlb.ddlbAuthors" listKey="AuthorNo" listValue="FirstName + ' ' + LastName" headerKey="" headerValue="Select Author" id="FourthAuthor" label="Fourth Author" name="book.Author4No" title="Select the name of the author"></s:select>
                                                    <tr>
                                                        <td class="Arial13BrownB">
                                                            <br />Description<br /><br />
                                                        </td>
                                                    </tr>
                                                    <s:textarea required="true" requiredposition="left" id="Synopsis" label="Synopsis" name="book.Synopsis" title="Enter the synopsis" cols="80" rows="5"></s:textarea>
                                                    <s:textarea required="true" requiredposition="left" id="AboutAuthors" label="About Authors" name="book.AboutAuthors" title="Enter the about author details" cols="80" rows="5"></s:textarea>
                                                    <s:textarea id="TopicsCovered" label="Topics Covered" name="book.TopicsCovered" title="Enter the topics covered in the book" cols="80" rows="5"></s:textarea>
                                                    <s:textarea id="ContentsCDROM" label="Contents Of CDROM" name="book.ContentsCDROM" title="Enter the contents of CDROM" cols="80" rows="5"></s:textarea>
                                                    <tr>
                                                        <td class="Arial13BrownB">
                                                            <br />Downloads<br /><br />
                                                        </td>
                                                    </tr>
                                                    <s:file id="Toc" name="Toc" label="TOC" title="Enter the path of the TOC"></s:file>
                                                    <s:file id="Sample Chapter" name="SampleChapter" label="Sample Chapter" title="Enter the path of the sample chapter"></s:file>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <br /><br />
                                                <s:submit theme="simple" cssStyle="background:url(/BookShop/images/submit_bg.gif) no-repeat scroll 37px 0px;" cssClass="buttonText" name="btnSubmit" id="btnSubmit" value="Save" />
                                                <s:reset theme="simple" cssStyle="background:url(/BookShop/images/submit_bg.gif) no-repeat scroll 37px 0px;" cssClass="buttonText" name="btnReset" id="btnReset" value="Clear" />
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr align="left" valign="top">
                                <td height="20" style="background:url('/BookShop/images/hr.jpg') repeat-x;">&nbsp;</td>
                            </tr>
                            <tr>
                                <td align="center">
                                    <table width="60px" border="0" align="right" cellpadding="3" cellspacing="1" style="border:#c3bca4 1px solid">
                                        <tr>
                                            <s:bean name="org.apache.struts2.util.Counter" id="counter">
                                                <s:param name="last" value="%{pageCount}" />
                                            </s:bean>
                                            <s:iterator value="#counter">
                                                <td align="center" width="2px" style="border:#c3bca4 1px solid; background:#efebde; font-family:sans-serif; font-size:12px; font-weight:bolder; text-align:center; vertical-align:middle;">
                                                    <a href="<s:url action="iterateManageBooksPage"><s:param name="pageNo"><s:property /></s:param></s:url>"><s:property /></a>
                                                </td>
                                            </s:iterator>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <br>
                                    <table class="view" align="center" cellspacing="0" cellpadding="0" width="100%">
                                        <tr>
                                            <th width="10%" align="center">&nbsp;</th>
                                            <th width="12%" class="Arial13BrownB" align="left">Book</th>
                                            <th width="13%" class="Arial13BrownB" align="left">ISBN</th>
                                            <th width="35%" class="Arial13BrownB" align="left">Synopsis</th>
                                            <th width="15%" class="Arial13BrownB" align="left">Cover Page</th>
                                            <th width="15%" class="Arial13BrownB" align="left">Downloads</th>
                                        </tr>
                                        <s:iterator value="books" id="books" status="stat">
                                            <tr title="Click to edit" class="<s:if test="#stat.odd == true">odd</s:if><s:else>even</s:else>">
                                                <td width="10%" valign="top">
                                                    <a href="<s:url action="doDeleteBook"><s:param name="book.BookNo" value="BookNo" /></s:url>">
                                                        <img src="/BookShop/images/TrashIcon.png" border="0" alt="Delete" style="cursor:pointer;"/>
                                                    </a>
                                                </td>
                                                <td width="12%" valign="top" align="left" style="cursor:pointer;" onclick="javascript:location.href='<s:url action='showEditBook'><s:param name='book.BookNo' value='BookNo' /></s:url>'">
                                                    <s:property value="BookName"/>
                                                </td>
                                                <td width="13%" valign="top" align="left" style="cursor:pointer;" onclick="javascript:location.href='<s:url action='showEditBook'><s:param name='book.BookNo' value='BookNo' /></s:url>'">
                                                    <s:property value="ISBN"/>
                                                </td>
                                                <td width="35%" valign="top" align="left" style="cursor:pointer;" onclick="javascript:location.href='<s:url action='showEditBook'><s:param name='book.BookNo' value='BookNo' /></s:url>'">
                                                    <s:property value="Synopsis"/>
                                                </td>
                                                <td width="15%" valign="top" align="left" style="cursor:pointer;" onclick="javascript:location.href='<s:url action='showEditBook'><s:param name='book.BookNo' value='BookNo' /></s:url>'">
                                                    <s:if test="CoverPage==''">
                                                        <img src="/BookShop/images/imgNA.jpg" width="80px"/>
                                                    </s:if>
                                                    <s:else>
                                                        <img src="getFile.action?columnName=CoverPage&tableName=Books&whereClause=BookNo&whereClauseValue=<s:property value="BookNo" />" width="80px"/>
                                                    </s:else>
                                                </td>
                                                <td width="15%" valign="top" align="left" style="cursor:pointer;" onclick="javascript:location.href='<s:url action='showEditBook'><s:param name='book.BookNo' value='BookNo' /></s:url>'">
                                                    <a href="getFile.action?columnName=Toc&tableName=Books&whereClause=BookNo&whereClauseValue=<s:property value="BookNo" />">Toc</a>
                                                    <br/>
                                                    <a href="getFile.action?columnName=SampleChapter&tableName=Books&whereClause=BookNo&whereClauseValue=<s:property value="BookNo" />">Chapter</a>
                                                </td>
                                            </tr>
                                        </s:iterator>
                                        <s:if test="#books==null">
                                            <span style="font:16px/18px Georgia, serif; width:300px; color:#990000; height:37px;">Currently there exists no books in the database. Please add a few books to begin managing them.</span>
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