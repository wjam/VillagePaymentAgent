<%-- 
    Document   : allocateDeviceConfirmation
    Created on : 29-Sep-2010, 11:44:07
    Author     : Miroslav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
        <title>HafTrust Allocate Mobile Device - Confirmation Page</title>
    </head>
    <body>

        <h1 align="center">Allocate Mobile Device Confirmation</h1>
        <hr size="5">
        <p align="center">
            <b>Allocation of the Mobile Device to the Verifier has been successful</b>
        </p>
        <table border="0" align="center">
            <tbody>
                <tr bgcolor="#00FFFF">
                       <td colspan="3" align="left"><b>Verifier Details</b></td>
                </tr>
                <tr>
                    <td>First Name:</td>
                    <td><c:out value="${adBean.firstName}"></c:out> </td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td><c:out value="${adBean.lastName}"></c:out> </td>
                </tr>
                <tr>
                    <td>Email :</td>
                    <td><c:out value="${adBean.email}"></c:out> </td>
                </tr>
                <tr bgcolor="#00FFFF">
                       <td colspan="3" align="left"><b>Mobile Device Details</b></td>
                   </tr>
                   <tr>
                       <td>IMEI:</td>
                       <td><c:out value="${adBean.device.imei}"></c:out></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Number:</td>
                       <td><c:out value="${adBean.device.htMobileNumber}"></c:out></td>
                       <td></td>
                   </tr>
            </tbody>
        </table>
        <p align="right">
            <a href="index.htm">Home</a>
        </p>
        <hr size="5">
    </body>
</html>
