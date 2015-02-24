<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page isErrorPage="true" %>
<html>
    <head>
        <title>Error Page</title>
        <link href="/BookShop/css/stylesheet.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <div id="header">
            <center class="spanHeader">BookShop</center>
        </div>
        <font size="4" color="red">Your are seeing the error page.</font><br><br> <font size="2">Click<a href="showHomePage.action"> here </a>to return to the site.</font><br><br>
        <p style="font-family:serif; font-size:small; text-align:justify;">
            In order that the development team can address this error, please report what you were doing that caused this error.
            <br/><br/>
            The following information can help the development team find where the error happened and what can be done to prevent it from happening in the future.
        </p>
        <br/>
        <%
            if(null == exception){
                exception = (Throwable)request.getAttribute("org.apache.struts.action.EXCEPTION");
            }
        %>
        <pre style="font-size:12px; text-align:left;">
            <%
                if(null == exception){
                    out.write("Source of error is unknown.");
                }else{
                    java.io.StringWriter sw = new java.io.StringWriter();
                    java.io.PrintWriter pw = new java.io.PrintWriter(sw);
                    exception.printStackTrace(pw);
                    out.write(sw.getBuffer().toString());
                }
            %>
        </pre>
    </body>
</html>
