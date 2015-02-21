<%-- 
    Document   : saveVerificationConfirmation
    Created on : 01-Oct-2010, 10:31:19
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
        <title>HafTrust Verify Verifier Save Confirmation Page</title>
    </head>
    <body>

        <h1 align="center">Verifier Verification Save Confirmation</h1>
        <hr size="5">
        <p align="center">
            <b>Verification of the Verifier Candidate has been saved successful</b>
        </p>
        <table border="0" align="center">
            <tbody>
                <tr>
                    <td>Verifier First Name :</td>
                    <td><c:out value="${vvBean.firstName}"></c:out> </td>
                </tr>
                <tr>
                    <td>Verifier Last Name :</td>
                    <td><c:out value="${vvBean.lastName}"></c:out> </td>
                </tr>
            </tbody>
        </table>
        <p align="right">
            <a href="index.htm">Home</a>
        </p>
        <hr size="5">
    </body>
</html>
