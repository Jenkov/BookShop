<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Home Page</title>
        <meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
		<link href="/BookShop/css/stylesheet.css" type="text/css" rel="stylesheet">
        <s:head theme="ajax"/>
    </head>
    <body>
        <div id="header">
            <s:include value="userHeader.jsp" />
        </div>
        <table border="0" width="100%" cellpadding="0" cellspacing="0">
            <tr align="left" valign="top">
                <td>
                    <table border="0" width="100%" cellpadding="0" cellspacing="0">
                        <tr>
                            <td width="50%" align="left">
                                <s:if test="#session.username==null">
                                    <s:form action="doCustomerLogin" method="post" name="frmMemberLogin" id="frmMemberLogin">
                                        <table align="lf" cellspacing="0" cellpadding="4" border="0" width="248px">
                                            <tr>
                                                <td colspan="2">
                                                    <span style="padding-bottom:10px; font:16px/18px Georgia, serif; width:228px; color:#786e4e; height:37px;">Member Login</span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td colspan="2" align="left" class="error">
                                                    <s:property value="message" />
                                                </td>
                                            </tr>
                                            <s:textfield required="true" requiredposition="left" maxLength="25" label="Username" name="customer.Username" title="Enter Username"/>
                                            <s:password required="true" requiredposition="left" maxLength="8" label="Password" name="customer.Password" title="Enter Password"/>
                                            <tr>
                                                <td>
                                                    <s:submit cssClass="buttonText" cssStyle="background:url(/BookShop/images/submit_bg.gif) no-repeat scroll 37px 0px;" name="login" value="Login" />
                                                </td>
                                            </tr>
                                            <tr>
                                                <td align="left" colspan="2">
                                                    <s:a href="showForgotPassword.action">Forgot Password</s:a>
                                                </td>
                                            </tr>
                                        </table>
                                    </s:form>
                                </s:if>
                                <s:else>
                                    <table align="left" cellspacing="0" cellpadding="4" border="0" width="248px">
                                        <tr>
                                            <td align="left" valign="top">
                                                <span style="font:20px/26px Georgia,serif; width:228px; color:#786e4e; height:37px;">Welcome <s:property value="#session.username" /></span>
                                            </td>
                                        </tr>
                                    </table>
                                </s:else>
                            </td>
                            <td width="50%" align="right" valign="top">
                                <s:form name="frmSearch" id="frmSearch" method="post">
                                    <table cellspacing="0" cellpadding="4" border="0" width="300px">
                                        <tr>
                                            <td align="right">
                                                <span style="padding-left:55px; padding-bottom:10px; font:16px/18px Georgia, serif; width:228px; color:#786e4e; height:37px;">Search</span>
                                            </td>
                                        </tr>
                                        <tr><td>&nbsp;</td></tr>
                                        <tr>
                                            <td align="right">
                                                <table border="0" align="right" width="100%" cellpadding="0" cellspacing="0">
                                                    <s:textfield id="Search" name="SearchCriteria" title="Enter the search criteria" maxLength="25" size="25"/>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr><td>&nbsp;</td></tr>
                                        <tr>
                                            <td align="right">
                                                <table border="0" align="right" width="100%" cellpadding="0" cellspacing="0">
                                                    <s:submit action="showBooksSearchResults" theme="simple" cssStyle="background:url(/BookShop/images/submit_bg.gif) no-repeat scroll 33px 0px;" cssClass="buttonText" name="Book" id="Book" value="Book" />
                                                    <s:submit action="showAuthorsSearchResults" theme="simple" cssStyle="background:url(/BookShop/images/submit_bg.gif) no-repeat scroll 40px 0px;" cssClass="buttonText" name="Author" id="Author" value="Author" />
                                                    <s:submit action="showPublishersSearchResults" theme="simple" cssStyle="background:url(/BookShop/images/submit_bg.gif) no-repeat scroll 43px 0px;" cssClass="buttonText" name="Publisher" id="Publisher" value="Publisher" />
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                </s:form>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <table width="100%" class="Arial13GrayB" border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td width="15%" valign="top">
                    <table width="100%" class="Arial13GrayB" cellpadding="0" cellspacing="0">
                        <tr>
                            <td valign="top">
                                <fieldset>
                                    <legend>New Releases</legend>
                                    <table align="center" cellspacing="4" cellpadding="0" width="100%" class="Arial9GrayN">
                                        <s:iterator value="newReleasesBooks" id="newReleasesBooks">
                                            <tr title="Click to view book details">
                                                <td align="left" style="cursor:pointer;">
                                                    <a href='<s:url action='showBookDetails'><s:param name='book.BookNo' value='BookNo' /></s:url>'>
                                                        <s:property value="BookName"/>
                                                    </a>
                                                </td>
                                            </tr>
                                        </s:iterator>
                                    </table>
                                </fieldset>
                            </td>
                        </tr>
                    </table>
                    <br>
                    <table width="100%" class="Arial13GrayB" cellpadding="0" cellspacing="0">
                        <tr>
                            <td valign="top">
                                <fieldset>
                                    <legend>Our Authors</legend>
                                    <table align="center" cellspacing="4" cellpadding="0" width="100%" class="Arial9GrayN">
                                        <s:iterator value="authors" id="authors">
                                            <tr title="Click to view author details">
                                                <td align="left" style="cursor:pointer;">
                                                    <a href='<s:url action='showAuthorDetails'><s:param name='author.AuthorNo' value='AuthorNo' /></s:url>'>
                                                        <s:property value="FirstName"/> <s:property value="LastName"/>
                                                    </a>
                                                </td>
                                            </tr>
                                        </s:iterator>
                                    </table>
                                </fieldset>
                            </td>
                        </tr>
                    </table>
                    <br>
                    <table width="100%" class="Arial13GrayB" cellpadding="0" cellspacing="0">
                        <tr>
                            <td valign="top">
                                <fieldset>
                                    <legend>Our Publishers</legend>
                                    <table align="center" cellspacing="4" cellpadding="0" width="100%" class="Arial9GrayN">
                                        <s:iterator value="publishers" id="publishers">
                                            <tr title="Click to view publisher details">
                                                <td align="left" style="cursor:pointer;">
                                                    <a href='<s:url action='showPublisherDetails'><s:param name='publisher.PublisherNo' value='PublisherNo' /></s:url>'>
                                                        <s:property value="PublisherName"/>
                                                    </a>
                                                </td>
                                            </tr>
                                        </s:iterator>
                                    </table>
                                </fieldset>
                            </td>
                        </tr>
                    </table>
                </td>
                <td width="70%" valign="top" align="center">
                    <table width="100%" class="Arial13GrayB" cellpadding="10" cellspacing="0">
                        <tr>
                            <td>
                                <s:iterator value="categories" id="categories" status="categoriesStatus">
                                    <table align="center" border="0" cellspacing="4" cellpadding="2" width="33%" class="Verdana10BrownB" style="position:relative; float:left;">
                                        <tr>
                                            <td align="left" style="CURSOR: pointer;" title="<s:property value="Description"/>" valign="top">
                                                <a href='<s:url action='showAllBooksForCat'><s:param name='category.CategoryNo' value='CategoryNo' /></s:url>'>
                                                    <s:property value="Category"/>
                                                </a>
                                                <s:action name="showBooksForThisCategory" executeResult="false" id="booksVal">
                                                    <s:param name="CategoryNo"><s:property value="CategoryNo"/></s:param>
                                                </s:action>
                                                <s:iterator value="#booksVal.books" id="books" status="booksStatus">
                                                    <table align="left" border="0" cellspacing="1" cellpadding="1" width="33%" class="Arial9GrayN" style="position:relative; float:left;">
                                                        <tr>
                                                            <td title="<s:property value="Synopsis"/>">
                                                                <a href='<s:url action='showBookDetails'><s:param name='book.BookNo' value='BookNo' /></s:url>'>
                                                                    <img title="<s:property value="BookName"/>" alt="<s:property value="BookName"/>" src="getFile.action?columnName=CoverPage&tableName=Books&whereClause=BookNo&whereClauseValue=<s:property value="BookNo" />" height="50px" width="40px"/>
                                                                </a>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td title="Click here to add to shopping cart">
                                                                <s:if test="#session.username!=null">
                                                                    <a href="<s:url action="addToCart"><s:param name="BookNo"><s:property value="BookNo"/></s:param><s:param name="BookName"><s:property value="BookName"/></s:param><s:param name="Cost"><s:property value="Cost"/></s:param></s:url>">
                                                                        <img src="/BookShop/images/cart.jpg" style="cursor:pointer;" border="0"/>
                                                                    </a>
                                                                </s:if>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </s:iterator>
                                            </td>
                                        </tr>
                                    </table>
                                </s:iterator>
                            </td>
                        </tr>
                        <tr>
                            <td valign="top">
                                <fieldset>
                                    <legend align="center">Popular Searches</legend>
                                    <s:iterator value="popularSearches" id="popularSearches">
                                        <s:if test="#popularSearches[2]>=1 && #popularSearches[2]<5">
                                            <a href="<s:url action='performSearch'><s:param name='SearchCriteria' value='#popularSearches[1]' /><s:param name='searchType' value='#popularSearches[0]' /></s:url>" style="font-size:13px; cursor:pointer;" title="Click to search for <s:property value='#popularSearches[0]'/> called <s:property value='#popularSearches[1]'/>">
                                                <s:property value="#popularSearches[1]"/>
                                            </a>
                                        </s:if>
                                        <s:if test="#popularSearches[2]>=5 && #popularSearches[2]<10">
                                            <a href="<s:url action='performSearch'><s:param name='SearchCriteria' value='#popularSearches[1]' /><s:param name='searchType' value='#popularSearches[0]' /></s:url>" style="font-size:17px; cursor:pointer;" title="Click to search for <s:property value='#popularSearches[0]'/> called <s:property value='#popularSearches[1]'/>">
                                                <s:property value="#popularSearches[1]"/>
                                            </a>
                                        </s:if>
                                        <s:if test="#popularSearches[2]>=10 && #popularSearches[2]<15">
                                            <a href="<s:url action='performSearch'><s:param name='SearchCriteria' value='#popularSearches[1]' /><s:param name='searchType' value='#popularSearches[0]' /></s:url>" style="font-size:25px; cursor:pointer;" title="Click to search for <s:property value='#popularSearches[0]'/> called <s:property value='#popularSearches[1]'/>">
                                                <s:property value="#popularSearches[1]"/>
                                            </a>
                                        </s:if>
                                        <s:if test="#popularSearches[2]>=15 && #popularSearches[2]<20">
                                            <a href="<s:url action='performSearch'><s:param name='SearchCriteria' value='#popularSearches[1]' /><s:param name='searchType' value='#popularSearches[0]' /></s:url>" style="font-size:35px; cursor:pointer;" title="Click to search for <s:property value='#popularSearches[0]'/> called <s:property value='#popularSearches[1]'/>">
                                                <s:property value="#popularSearches[1]"/>
                                            </a>
                                        </s:if>
                                        <s:if test="#popularSearches[2]>=20">
                                            <a href="<s:url action='performSearch'><s:param name='SearchCriteria' value='#popularSearches[1]' /><s:param name='searchType' value='#popularSearches[0]' /></s:url>" style="font-size:40px; cursor:pointer;" title="Click to search for <s:property value='#popularSearches[0]'/> called <s:property value='#popularSearches[1]'/>">
                                                <s:property value="#popularSearches[1]"/>
                                            </a>
                                        </s:if>
                                    </s:iterator>
                                </fieldset>
                            </td>
                        </tr>
                    </table>
                </td>
                <td width="15%" valign="top">
                    <table width="100%" class="Arial13GrayB" cellpadding="0" cellspacing="0">
                        <tr>
                            <td valign="top">
                                <fieldset>
                                    <legend>Updated Books</legend>
                                    <table align="center" cellspacing="4" cellpadding="0" width="100%" class="Arial9GrayN">
                                        <s:iterator value="updatedBooks" id="updatedBooks">
                                            <tr title="Click to view book details">
                                                <td align="left" style="cursor:pointer;">
                                                    <a href='<s:url action='showBookDetails'><s:param name='book.BookNo' value='BookNo' /></s:url>'>
                                                        <s:property value="BookName"/>
                                                    </a>
                                                </td>
                                            </tr>
                                        </s:iterator>
                                    </table>
                                </fieldset>
                            </td>
                        </tr>
                    </table>
                    <br>
                    <table width="100%" class="Arial13GrayB" cellpadding="0" cellspacing="0">
                        <tr>
                            <td valign="top">
                                <fieldset>
                                    <legend>Top Titles</legend>
                                    <table align="center" cellspacing="4" cellpadding="0" width="100%" class="Arial9GrayN">
                                        <s:iterator value="topTitlesBooks" id="topTitlesBooks">
                                            <tr title="Click to view book details">
                                                <td align="left" style="cursor:pointer;">
                                                    <a href='<s:url action='showBookDetails'><s:param name='book.BookNo' value='BookNo' /></s:url>'>
                                                        <s:property value="BookName"/>
                                                    </a>
                                                </td>
                                            </tr>
                                        </s:iterator>
                                    </table>
                                </fieldset>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
		<s:include value="/common/footer.jsp" />
    </body>
</html>