<%-- 
    Document   : deleteVerification
    Created on : 01-Oct-2010, 12:07:40
    Author     : Miroslav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page  import="org.haftrust.verifier.view.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
        <script language="javascript" type="text/javascript" src="JavaScript/datetimepicker.js"></script>
        <title>HafTrust Verify Verifier Delete Application Page</title>
    </head>
    <body>
       <h1 align="center">Verifier Verification - Delete Verifier Candidate's Application</h1>
       <hr size="5">
       <p align="center">
            <b>Provide the reason for deleting the verifier candidate's application</b>
       </p>
       <form:form commandName="vvBean" method="post">
            <table border="0" align="center">
               <tbody>
                   <tr>
                       <td>Verification Comment :</td>
                       <td><form:textarea path="verifierVerificationComment" rows="3" cols="40"/></td>
                       <td><form:errors path="verifierVerificationComment" cssClass="error"/></td>
                   </tr>
                    <tr>
                       <td></td>
                       <td align="right"><input type="submit" value="Back" name="_target3"/></td>
                       <td align="left"><input type="submit" value="Confirm" name="_finish"/></td>
                   </tr>
               </tbody>
           </table>
       </form:form>
       <hr size="5">
    </body>
</html>
