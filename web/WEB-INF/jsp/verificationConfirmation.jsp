<%-- 
    Document   : verificationConfirmation
    Created on : 22-Sep-2010, 10:16:46
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
        <title>HafTrust Verify Verifier Confirmation Page</title>
    </head>
    <body>

        <h1 align="center">Verifier Verification Confirmation</h1>
        <hr size="5">
        <p align="center">
            <b>Verification of the Verifier Candidate has been successful</b>
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
                <tr>
                    <td>Filed Operative Manager ID :</td>
                    <td><c:out value="${vvBean.filedOperativeManager.id}"></c:out> </td>
                </tr>
                <tr>
                    <td>Interview ID : </td>
                    <td><c:out value="${vvBean.interview.id}"></c:out> </td>
                </tr>
            </tbody>
        </table>
        <p align="right">
            <a href="index.htm">Home</a>
        </p>
        <hr size="5">
    </body>
</html>
