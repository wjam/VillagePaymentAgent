<%-- 
    Document   : selectDistrict
    Created on : 10-Sep-2010, 11:01:16
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
        <title>HafTrust Register Verifier Select District Page</title>
    </head>
    <body>
       <h1 align="center">Verifier Registration</h1>
       <hr size="5">
       <p align="center">
            <b>Select your District</b>
       </p>
       <form:form commandName="rvBean" method="post">
           <table border="0" align="center">
               <tbody>
                   <tr>
                       <td>Country : </td>
                       <td><c:out value="${rvBean.country.description}"/></td>
                   </tr>
                   <tr>
                       <td>Region : </td>
                       <td><c:out value="${rvBean.region.description}"/></td>
                   </tr>
                   <tr>

                       <td>District : </td>
                       <td><form:select path="idDistrict">
                            <form:options items="${districtList}" itemValue="id" itemLabel="description" />
                        </form:select></td>
                   </tr>
                   <tr>
                       <td align="right"><input type="submit" value="Cancel" name="_cancel"/></td>
                       <td align="right"><input type="submit" value="Back" name="_target2"/></td>
                       <td align="left"><input type="submit" value="Next" name="_target4"/></td>
                   </tr>
               </tbody>
           </table>
       </form:form>
        <%--<p align="right">
            <a href="index.htm">Home</a>
        </p>--%>
       <hr size="5">
    </body>
</html>
