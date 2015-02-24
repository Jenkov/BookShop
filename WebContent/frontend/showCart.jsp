<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Your Cart</title>
        <meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
        <link href="/BookShop/css/stylesheet.css" type="text/css" rel="stylesheet">
        <s:head theme="ajax"/>
    </head>
    <body>
        <div id="header">
            <s:include value="userHeader.jsp" />
        </div>
        <table width="100%" border="0" cellspacing="4" cellpadding="1">
            <tr>
                <td colspan="2" align="left" valign="top">
                    <span style="font:28px Georgia, serif; width:300px; color:#990000; height:37px;">Your Cart</span><br/><br/>
                </td>
            </tr>
            <tr>
                <td align="center" valign="top" width="5%">&nbsp;</td>
                <td align="left" valign="top" style='border:1px solid #990033; background-color:#FFFF99;'>
                    <strong>Book (Date and Time)</strong>
                </td>
                <td align="center" valign="top" style='border:1px solid #990033; background-color:#FFFF99;'>
                    <strong>Cost</strong>
                </td>
            </tr>
            <s:iterator value="cartItems">
                <tr>
                    <td align='center' valign='top'>
                        <a href="<s:url action="removeFromCart"><s:param name="BookName"><s:property value="BookName"/></s:param></s:url>">
                            <img src="/BookShop/images/removeFromCart.jpg" border="0" width="25px" alt="Click to remove the Book from the cart">
                        </a>
                    </td>
                    <td align='left' style='border:1px dashed #990033;'>
                        <s:property value="BookName"/>
                    </td>
                    <td align='center' style='border:1px dashed #990033;'>
                        <s:property value="Cost"/>
                    </td>
                </tr>
            </s:iterator>
            <tr>
                <td colspan="2" align="right" valign="top" style='border:2px dashed #990033;'>
                    <strong>Total:</strong>
                </td>
                <td align="center" valign="top" style='border:2px dashed #990033;'>
                    <strong><s:property value="totalCost"/></strong>
                </td>
            </tr>
        </table>
        <s:if test="totalCost<=0">
            <span style="font:16px/18px Georgia, serif; width:300px; color:#990000; height:37px;">Your Shopping Cart is empty.<br>Your Shopping Cart lives to serve. Give it purpose by filling it with books.<br>To put something in your Shopping Cart, start by searching or browsing through any of our books.<br>When an item interests you, click the Add to Cart button.</span>
        </s:if>
        <s:else>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td align="right" valign="top">
                        <br/>
                        <s:i18n name="bookshop">
                            <s:if test="getText('googleMerchantID')!=''">
                                <a href="performTransaction.action">
                                    <img src="http://checkout.google.com/buttons/checkout.gif?merchant_id=<s:text name='googleMerchantID'/>&w=180&h=46&style=white&variant=text&loc=en_US"/>
                                </a>
                            </s:if>
                        </s:i18n>
                    </td>
                </tr>
            </table>
        </s:else>
        <s:include value="/common/footer.jsp" />
    </body>
</html>