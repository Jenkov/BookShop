<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>BookShop - Performing Transaction - Please wait....</title>
        <meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
        <link href="/BookShop/css/stylesheet.css" type="text/css" rel="stylesheet">
        <s:head theme="ajax"/>
    </head>
    <body>
        <s:i18n name="bookshop">
            <form method="POST" action="https://sandbox.google.com/checkout/api/checkout/v2/checkoutForm/Merchant/<s:text name='googleMerchantID'/>" accept-charset="utf-8">
                <s:iterator value="cartItems" status="cartItemsStatus">
                    <input type="hidden" name="item_name_<s:property value="#cartItemsStatus.index" />" value="<s:property value="BookName" />">
                    <input type="hidden" name="item_description_<s:property value="#cartItemsStatus.index" />" value="<s:property value="BookName" />">
                    <input type="hidden" name="item_quantity_<s:property value="#cartItemsStatus.index" />" value="1">
                    <input type="hidden" name="item_price_<s:property value="#cartItemsStatus.index" />" value="<s:property value="Cost" />">
                </s:iterator>

                <input type="hidden" name="checkout-flow-support.merchant-checkout-flow-support.continue-shopping-url" value="http://localhost:8080/BookShop/"/>
                <input type="hidden" name="_charset_"/>
            </form>
        </s:i18n>
        <script>
            <!--
                document.forms[0].submit();
            -->
        </script>
    </body>
</html>