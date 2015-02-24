<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Manage Authors</title>
		<meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
		<link href="/BookShop/css/stylesheet.css" type="text/css" rel="stylesheet">
        <s:head theme="ajax"/>
    </head>
	<body>
		<div id="header">
			<s:include value="header.jsp" />
		</div>
		<s:form action="doInsertAuthor" method="post" name="frmAuthors" id="frmAuthors" enctype="multipart/form-data" validate="true">
            <s:token/>
            <s:hidden name="author.AuthorNo" id="AuthorNo"/>
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
                                                <span>Manage Authors</span>
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
                                                            <br />Name<br /><br />
                                                        </td>
                                                    </tr>
                                                    <s:actionerror/>
                                                    <s:textfield required="true" requiredposition="left" id="FirstName" label="First Name" name="author.FirstName" title="Enter the first name" maxLength="25" size="55"/>
                                                    <s:textfield required="true" requiredposition="left" id="LastName" label="Last Name" name="author.LastName" title="Enter the last name" maxLength="25" size="55"/>
                                                    <tr>
                                                        <td class="Arial13BrownB">
                                                            <br />Mailing Address<br /><br />
                                                        </td>
                                                    </tr>
                                                    <s:textfield id="Address1" label="Address Line 1" name="author.Address1" title="Enter the street address" maxLength="50" size="55"/>
                                                    <s:textfield id="Address2" label="Address Line 2" name="author.Address2" title="Enter the street address" maxLength="50" size="55"/>
                                                    <s:select list="ddlb.ddlbCitiesStates" listKey="CityStateNo" listValue="City + ' - ' + State" headerKey="" headerValue="Select City/State" id="CityStateNo" name="author.CityStateNo" label="City / State" title="Select the city/state"></s:select>
                                                    <s:select list="ddlb.ddlbCountries" listKey="CountryNo" listValue="Country" headerKey="" headerValue="Select Country" id="CountryNo" name="author.CountryNo" label="Country" title="Select the country"></s:select>
                                                    <s:textfield id="Pincode" label="Pincode" name="author.Pincode" title="Enter the pincode" maxLength="15" size="20"/>
                                                    <tr>
                                                        <td class="Arial13BrownB">
                                                            <br />Author Details<br /><br />
                                                        </td>
                                                    </tr>
                                                    <s:datetimepicker name="author.Dob" label="Birthdate" displayFormat="yyyy-MM-dd"/>
                                                    <s:textfield required="true" requiredposition="left" id="Degree" label="Degree" name="author.Degree" title="Enter the degree" maxLength="25" size="55"/>
                                                    <s:textfield required="true" requiredposition="left" id="EmailAddress" label="Email Address" name="author.EmailAddress" title="Enter the email address" maxLength="50" size="55"/>
                                                    <s:file id="Photograph" name="Photograph" label="Photograph" title="Enter the path of the photograph"></s:file>
                                                    <s:textarea id="Speciality" label="Speciality" name="author.Speciality" title="Enter the speciality" cols="80" rows="5"></s:textarea>
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
                                                    <a href="<s:url action="iterateManageAuthorsPage"><s:param name="pageNo"><s:property /></s:param></s:url>"><s:property /></a>
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
                                            <th width="15%" class="Arial13BrownB" align="left">Name</th>
                                            <th width="60%" class="Arial13BrownB" align="left">Speciality</th>
                                            <th width="15%" class="Arial13BrownB" align="left">Photograph</th>
                                        </tr>
                                        <s:iterator value="authors" id="authors" status="stat">
                                            <tr title="Click to edit" class="<s:if test="#stat.odd == true">odd</s:if><s:else>even</s:else>">
                                                <td width="10%" valign="top">
                                                    <a href="<s:url action="doDeleteAuthor"><s:param name="author.AuthorNo" value="AuthorNo" /></s:url>">
                                                        <img src="/BookShop/images/TrashIcon.png" border="0" alt="Delete" style="cursor:pointer;"/>
                                                    </a>
                                                </td>
                                                <td width="15%" valign="top" align="left" style="cursor:pointer;" onclick="javascript:location.href='<s:url action='showEditAuthor'><s:param name='author.AuthorNo' value='AuthorNo' /></s:url>'">
                                                    <s:property value="FirstName"/> <s:property value="LastName" />
                                                </td>
                                                <td width="60%" valign="top" align="left" style="cursor:pointer;" onclick="javascript:location.href='<s:url action='showEditAuthor'><s:param name='author.AuthorNo' value='AuthorNo' /></s:url>'">
                                                    <s:property value="Speciality"/>
                                                </td>
                                                <td width="15%" valign="top" align="left" style="cursor:pointer;" onclick="javascript:location.href='<s:url action='showEditAuthor'><s:param name='author.AuthorNo' value='AuthorNo' /></s:url>'">
                                                    <img src="getFile.action?columnName=Photograph&tableName=Authors&whereClause=AuthorNo&whereClauseValue=<s:property value="AuthorNo" />" width="80px"/>
                                                </td>
                                            </tr>
                                        </s:iterator>
                                        <s:if test="#authors==null">
                                            <span style="font:16px/18px Georgia, serif; width:300px; color:#990000; height:37px;">Currently there exists no authors in the database. Please add a few authors to begin managing them.</span>
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