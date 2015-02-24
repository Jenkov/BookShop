<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Manage Users</title>
		<meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
		<link href="/BookShop/css/stylesheet.css" type="text/css" rel="stylesheet">
        <s:head/>
    </head>
	<body>
		<div id="header">
			<s:include value="header.jsp" />
		</div>
		<s:form action="doInsertUser" method="post" name="frmUsers" id="frmUsers" validate="true">
            <s:token/>
            <s:hidden name="systemuser.UserNo" id="UserNo"/>
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
                                                <span>Manage Users</span>
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
                                                    <s:textfield required="true" requiredposition="left" id="FirstName" label="First Name" name="systemuser.FirstName" title="Enter the first name" maxLength="25" size="55"/>
                                                    <s:textfield required="true" requiredposition="left" id="LastName" label="Last Name" name="systemuser.LastName" title="Enter the last name" maxLength="25" size="55"/>
                                                    <s:actionerror/>
                                                    <tr>
                                                        <td class="Arial13BrownB">
                                                            <br />Email<br /><br />
                                                        </td>
                                                    </tr>
                                                    <s:textfield required="true" requiredposition="left" id="EmailAddress" label="Email Address" name="systemuser.EmailAddress" title="Enter the email address" maxLength="50" size="55"/>
                                                    <tr>
                                                        <td class="Arial13BrownB">
                                                            <br />Login Details<br /><br />
                                                        </td>
                                                    </tr>
                                                    <s:textfield required="true" requiredposition="left" maxLength="25" label="Username" name="systemuser.Username" title="Enter Username" />
                                                    <s:textfield required="true" requiredposition="left" maxLength="8" label="Password" name="systemuser.Password" title="Enter Password" />
                                                    <tr>
                                                        <td class="Arial13BrownB">
                                                            <br />Management<br /><br />
                                                        </td>
                                                    </tr>
                                                    <s:checkbox label="Manage Countries" id="ManageCountries" name="systemuser.ManageCountries" title="Select to manage countries"/>
                                                    <s:checkbox label="Manage City/State" id="ManageCityState" name="systemuser.ManageCityState" title="Select to manage cities/states"/>
                                                    <s:checkbox label="Manage Authors" id="ManageAuthors" name="systemuser.ManageAuthors" title="Select to manage authors"/>
                                                    <s:checkbox label="Manage Publishers" id="ManagePublishers" name="systemuser.ManagePublishers" title="Select to manage publishers"/>
                                                    <s:checkbox label="Manage Catgeories" id="ManageCategories" name="systemuser.ManageCategories" title="Select to manage categories"/>
                                                    <s:checkbox label="Manage Books" id="ManageBooks" name="systemuser.ManageBooks" title="Select to manage books"/>
                                                    <s:checkbox label="Manage Users" id="ManageUsers" name="systemuser.ManageUsers" title="Select to manage system users"/>
                                                    <s:checkbox label="Manage Customers" id="ManageCustomers" name="systemuser.ManageCustomers" title="Select to manage customers"/>
                                                    <s:checkbox label="Manage Transactions" id="ManageTransactions" name="systemuser.ManageTransactions" title="Select to manage transactions"/>
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
                                                    <a href="<s:url action="iterateManageUsersPage"><s:param name="pageNo"><s:property /></s:param></s:url>"><s:property /></a>
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
                                            <th width="45%" class="Arial13BrownB" align="left">Email Address</th>
                                            <th width="45%" class="Arial13BrownB" align="left">Username</th>
                                        </tr>
                                        <s:iterator value="systemusers" id="systemusers" status="stat">
                                            <tr title="Click to edit" class="<s:if test="#stat.odd == true">odd</s:if><s:else>even</s:else>">
                                                <td width="10%" valign="top">
                                                    <s:if test="Username=='admin'">
                                                        <img src="/BookShop/images/TrashIcon.png" border="0" alt="Cannot be deleted"/>
                                                    </s:if>
                                                    <s:else>
                                                        <a href="<s:url action="doDeleteUser"><s:param name="systemuser.UserNo" value="UserNo" /></s:url>">
                                                            <img src="/BookShop/images/TrashIcon.png" border="0" alt="Delete" style="cursor:pointer;"/>
                                                        </a>
                                                    </s:else>
                                                </td>
                                                <td width="45%" valign="top" align="left" style="cursor:pointer;" onclick="javascript:location.href='<s:url action='showEditUser'><s:param name='systemuser.UserNo' value='UserNo' /></s:url>'">
                                                    <s:property value="EmailAddress"/>
                                                </td>
                                                <td width="45%" valign="top" align="left" style="cursor:pointer;" onclick="javascript:location.href='<s:url action='showEditUser'><s:param name='systemuser.UserNo' value='UserNo' /></s:url>'">
                                                    <s:property value="Username"/>
                                                </td>
                                            </tr>
                                        </s:iterator>
                                        <s:if test="#systemusers==null">
                                            <span style="font:16px/18px Georgia, serif; width:300px; color:#990000; height:37px;">Currently there exists no users in the database. Please add a few users to begin managing them.</span>
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