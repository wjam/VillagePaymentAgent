<%-- 
    Document   : registerConfirmation
    Created on : 15-Sep-2010, 14:57:58
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
        <title>HafTrust Register Verifier Confirmation Page</title>
    </head>
    <body>

        <h1 align="center">Verifier Registration Confirmation</h1>
        <hr size="5">
        <p align="center">
            <b>Registration of the Verifier Candidate has been successful</b>
        </p>
        <table border="0" align="center">
            <tbody>
                <tr>
                    <td>ID : </td>
                    <td><c:out value="${rvBean.verifier.id}"></c:out> </td>
                </tr>
                <tr>
                    <td>Email : </td>
                    <td><c:out value="${rvBean.email}"></c:out> </td>
                </tr>
                <tr>
                    <td>Address ID : </td>
                    <td><c:out value="${rvBean.address.id}"></c:out> </td>
                </tr>
                <tr>
                    <td>Image ID : </td>
                    <td><c:out value="${rvBean.image.id}"></c:out> </td>
                </tr>
                <tr>
                    <td>Identity Document ID : </td>
                    <td><c:out value="${rvBean.identityDocument.id}"></c:out> </td>
                </tr>
                <tr>
                    <td>Bank Account Number : </td>
                    <td><c:out value="${rvBean.bank.accountNumber}"></c:out> </td>
                </tr>
                <tr>
                    <td>Reference 1 ID : </td>
                    <td><c:out value="${rvBean.reference1.id}"></c:out> </td>
                </tr>
                <tr>
                    <td>Reference 2 ID : </td>
                    <td><c:out value="${rvBean.reference2.id}"></c:out> </td>
                </tr>
            </tbody>
        </table>
        <p align="right">
            <a href="index.htm">Home</a>
        </p>
        <hr size="5">
    </body>
</html>
