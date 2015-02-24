<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Manage Publishers</title>
		<meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
		<link href="/BookShop/css/stylesheet.css" type="text/css" rel="stylesheet">
        <s:head/>
    </head>
	<body>
		<div id="header">
			<s:include value="header.jsp" />
		</div>
        <s:form action="doInsertPublisher" method="post" name="frmPublishers" id="frmPublishers" validate="true">
            <s:token/>
			<s:hidden name="publisher.PublisherNo" id="PublisherNo"/>
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
                                                <span>Manage Publishers</span>
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
                                                            <br />Publisher Details<br /><br />
                                                        </td>
                                                    </tr>
                                                    <s:actionerror/>
                                                    <s:textfield required="true" requiredposition="left" id="PublisherName" label="Publisher Name" name="publisher.PublisherName" title="Enter the publisher name" maxLength="50" size="55"/>
                                                    <s:textfield required="true" requiredposition="left" id="EmailAddress" label="Email Address" name="publisher.EmailAddress" title="Enter the email address" maxLength="50" size="55"/>
                                                    <tr>
                                                        <td class="Arial13BrownB">
                                                            <br />Mailing Address<br /><br />
                                                        </td>
                                                    </tr>
                                                    <s:textfield id="Address1" label="Address Line 1" name="publisher.Address1" title="Enter the street address" maxLength="50" size="55"/>
                                                    <s:textfield id="Address2" label="Address Line 2" name="publisher.Address2" title="Enter the street address" maxLength="50" size="55"/>
                                                    <s:select list="ddlb.ddlbCitiesStates" listKey="CityStateNo" listValue="City + ' - ' + State" headerKey="" headerValue="Select City/State" id="CityStateNo" name="publisher.CityStateNo" label="City / State" title="Select the city/state"></s:select>
                                                    <s:select list="ddlb.ddlbCountries" listKey="CountryNo" listValue="Country" headerKey="" headerValue="Select Country" id="CountryNo" name="publisher.CountryNo" label="Country" title="Select the country"></s:select>
                                                    <s:textfield id="Pincode" label="Pincode" name="publisher.Pincode" title="Enter the pincode" maxLength="15" size="20"/>
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
                                                    <a href="<s:url action="iterateManagePublishersPage"><s:param name="pageNo"><s:property /></s:param></s:url>"><s:property /></a>
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
                                            <th width="35%" class="Arial13BrownB" align="left">Publisher Name</th>
                                            <th width="55%" class="Arial13BrownB" align="left">Email Address</th>
                                        </tr>
                                        <s:iterator value="publishers" id="publishers" status="stat">
                                            <tr title="Click to edit" class="<s:if test="#stat.odd == true">odd</s:if><s:else>even</s:else>">
                                                <td width="10%" valign="top">
                                                    <a href="<s:url action="doDeletePublisher"><s:param name="publisher.PublisherNo" value="PublisherNo" /></s:url>">
                                                        <img src="/BookShop/images/TrashIcon.png" border="0" alt="Delete" style="cursor:pointer;"/>
                                                    </a>
                                                </td>
                                                <td width="35%" valign="top" align="left" style="cursor:pointer;" onclick="javascript:location.href='<s:url action='showEditPublisher'><s:param name='publisher.PublisherNo' value='PublisherNo' /></s:url>'">
                                                    <s:property value="PublisherName"/>
                                                </td>
                                                <td width="55%" valign="top" align="left" style="cursor:pointer;" onclick="javascript:location.href='<s:url action='showEditPublisher'><s:param name='publisher.PublisherNo' value='PublisherNo' /></s:url>'">
                                                    <s:property value="EmailAddress"/>
                                                </td>
                                            </tr>
                                        </s:iterator>
                                        <s:if test="#publishers==null">
                                            <span style="font:16px/18px Georgia, serif; width:300px; color:#990000; height:37px;">Currently there exists no publishers in the database. Please add a few publishers to begin managing them.</span>
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