<%-- 
    Document   : cancelAllocateDevice
    Created on : 29-Sep-2010, 11:42:01
    Author     : Miroslav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="org.haftrust.verifier.view.*" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HafTrust Register Verifier - Cancel Registration Page</title>
        <style>
            .error {
                color: red;
            }
        </style>
    </head>
    <body>
        <h1 align="center">Cancel Verifier Registration</h1>
       <hr size="5">
       <p align="center">
            <b>Are you sure?</b>
        </p>
       <form:form commandName="adBean" method="post">
           <table border="0" align="center">
               <tbody>
                   <tr>
                      <td align="right"><input type="submit" value="No" name="<%=((AllocateDeviceBean) request.getAttribute("adBean")).getTarget()%>"/></td>
                      <td colspan="2" align="left"><input type="submit" value="Yes" name="_cancel"/></td>
                   </tr>
               </tbody>
           </table>
       </form:form>
       <hr size="5">
    </body>
</html>
