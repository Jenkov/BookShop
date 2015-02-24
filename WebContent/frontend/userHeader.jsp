<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tr>
        <td width="30%">
           <table border="0" cellpadding="0" cellspacing="0" align="left" width="100%">
                <tr>
                    <td align="left">
                        <img src="/BookShop/images/b.gif" width="15px"/>
                        <img src="/BookShop/images/o1.gif" width="15px"/>
                        <img src="/BookShop/images/o2.gif" width="15px"/>
                        <img src="/BookShop/images/k.gif" width="15px"/>
                        <img src="/BookShop/images/s.gif" width="15px"/>
                        <img src="/BookShop/images/h.gif" width="15px"/>
                        <img src="/BookShop/images/o2.gif" width="15px"/>
                        <img src="/BookShop/images/p.gif" width="15px"/>
                    </td>
                </tr>
            </table>
        </td>
        <td width="70%">
            <table border="0" width="100%" cellspacing="0" cellpadding="0">
                <tr>
                    <td align="right">
                        <s:if test="#session.username==null">&nbsp;</s:if>
                        <s:else>
                            <font class="Arial13GrayB">Last Login IP:</font><font class="Arial13BrownB"><s:property value="#session.lastip" /></font>&nbsp;&nbsp;<font class="Arial13GrayB">Last Login Date:</font><font class="Arial13BrownB"><s:property value="#session.lastlogin" /></font>
                        </s:else>
                    </td>
                </tr>
            </table>
            <br>
            <s:if test="#session.username==null">
                <table border="0" cellpadding="0" cellspacing="0" width="70%">
                    <tr>
                        <td align="right" class="buttonText" width="10%">
                            <s:a href="showHomePage.action">Home</s:a>
                        </td>
                        <td align="right" class="buttonText" width="10%">
                            <s:a href="showRegistrationPage.action">Sign Up</s:a>
                        </td>
                        <td align="right" class="buttonText" width="10%">
                            <s:a href="admin.action">Administration</s:a>
                        </td>
                        <td align="right" class="buttonText" width="10%">
                            <s:a href="showSearchResults.action">Search</s:a>
                        </td>
                    </tr>
                </table>
            </s:if>
            <s:else>
                <table border="0" cellpadding="0" cellspacing="0" width="50%">
                    <tr>
                        <td align="right" class="buttonText" width="10%">
                            <s:a href="showHomePage.action">Home</s:a>
                        </td>
                        <td align="right" class="buttonText" width="10%">
                            <s:a href="showCart.action">Cart</s:a>
                        </td>
                        <td align="right" class="buttonText" width="10%">
                            <s:a href="showSearchResults.action">Search</s:a>
                        </td>
                        <td align="right" class="buttonText" width="10%">
                            <a href="<s:url action="doCustomerLogout" />">Logout</a>
                        </td>
                    </tr>
                </table>
            </s:else>
        </td>
    </tr>
</table>