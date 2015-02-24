<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
		<title>Member Registration</title>
		<meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
		<link href="/BookShop/css/stylesheet.css" type="text/css" rel="stylesheet">
        <s:head theme="ajax"/>
    </head>
    <body>
        <div id="header">
            <s:include value="userHeader.jsp" />
        </div>
		<s:form action="doInsertCustomer" method="post" name="frmCustomers" id="frmCustomers" validate="true">
            <s:hidden name="customer.CustomerNo" id="CustomerNo"/>
            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td>
                        <table border="0" cellpadding="0" cellspacing="0" width="100%">
                            <tr>
                                <td valign="top" align="left" class="spanHeader">
                                    <span>Sign-Up</span>
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
                                        <s:textfield required="true" requiredposition="left" id="FirstName" label="First Name" name="customer.FirstName" title="Enter the first name" maxLength="25" size="55"/>
                                        <s:textfield required="true" requiredposition="left" id="LastName" label="Last Name" name="customer.LastName" title="Enter the last name" maxLength="25" size="55"/>
                                        <tr>
                                            <td class="Arial13BrownB">
                                                <br />Mailing Address<br /><br />
                                            </td>
                                        </tr>
                                        <s:textfield id="Address1" label="Address Line 1" name="customer.Address1" title="Enter the street address" maxLength="50" size="55"/>
                                        <s:textfield id="Address2" label="Address Line 2" name="customer.Address2" title="Enter the street address" maxLength="50" size="55"/>
                                        <s:select list="ddlb.ddlbCitiesStates" listKey="CityStateNo" listValue="City + ' - ' + State" headerKey="" headerValue="Select City/State" id="CityStateNo" name="customer.CityStateNo" label="City / State" title="Select the city/state"></s:select>
                                        <s:select list="ddlb.ddlbCountries" listKey="CountryNo" listValue="Country" headerKey="" headerValue="Select Country" id="CountryNo" name="customer.CountryNo" label="Country" title="Select the country"></s:select>
                                        <s:textfield id="Pincode" label="Pincode" name="customer.Pincode" title="Enter the pincode" maxLength="15" size="20"/>
                                        <s:actionerror/>
                                        <tr>
                                            <td class="Arial13BrownB">
                                                <br />Email<br /><br />
                                            </td>
                                        </tr>
                                        <s:textfield required="true" requiredposition="left" id="EmailAddress" label="Email Address" name="customer.EmailAddress" title="Enter the email address" maxLength="50" size="55"/>
                                        <tr>
                                            <td class="Arial13BrownB">
                                                <br />Login Details<br /><br />
                                            </td>
                                        </tr>
                                        <s:textfield required="true" requiredposition="left" maxLength="25" label="Username" name="customer.Username" title="Enter Username" />
                                        <s:textfield required="true" requiredposition="left" maxLength="8" label="Password" name="customer.Password" title="Enter Password" />
                                        <tr>
                                            <td class="Arial13BrownB">
                                                <br />Special Occassion<br /><br />
                                            </td>
                                        </tr>
                                        <s:datetimepicker name="customer.Dob" label="Birthdate" displayFormat="yyyy-MM-dd"/>
                                        <tr>
                                            <td class="Arial13BrownB">
                                                <br />Subscribe To<br /><br />
                                            </td>
                                        </tr>
                                        <s:checkbox label="New Releases" id="NewReleases" name="customer.NewRelease"/>
                                        <s:checkbox label="Book Updates" id="BookUpdates" name="customer.BookUpdates"/>
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
            </table>
        </s:form>
		<s:include value="/common/footer.jsp" />
    </body>
</html>