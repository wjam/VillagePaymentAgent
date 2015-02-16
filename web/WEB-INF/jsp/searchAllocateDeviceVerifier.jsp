<%-- 
    Document   : searchAllocateDeviceVerifier
    Created on : 29-Sep-2010, 11:38:28
    Author     : Miroslav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
        <title>HafTrust Allocate Mobile Device - Select Region Page</title>
    </head>
    <body>
       <h1 align="center">Mobile Device Allocation</h1>
       <hr size="5">
       <p align="center">
            <b>Select Verifier's Region</b>
       </p>
           <table border="0" align="center">
               <tbody>
                   <tr>
                       <td>Country : </td>
                       <td><c:out value="${adBean.country.description}"/></td>
                   </tr>
       <form:form commandName="adBean" method="post">
                   <tr>

                       <td>Region : </td>
                       <td><form:select path="idRegion">
                            <form:options items="${regionList}" itemValue="id" itemLabel="description" />
                        </form:select></td>
                   </tr>
                   <tr>
                       <td align="right"><input type="submit" value="Cancel" name="_target4"/></td>
                       <td align="right"><input type="submit" value="Back" name="_target0"/></td>
                       <td align="left"><input type="submit" value="Search" name="_target2"/></td>
                   </tr>
               </tbody>
           </table>
       </form:form>
       <hr size="5">
    </body>
</html>
