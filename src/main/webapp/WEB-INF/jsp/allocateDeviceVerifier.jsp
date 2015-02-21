<%-- 
    Document   : allocateDeviceVerifier
    Created on : 29-Sep-2010, 11:41:17
    Author     : Miroslav
--%>

<%@page import="org.haftrust.verifier.model.Device"%>
<%@page import="java.util.List"%>
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
        <title>HafTrust Allocate Mobile Device - Select Mobile Device Page</title>
    </head>
    <body>
        <%
            if(((List<Device>) request.getAttribute("unallocatedDeviceList")).size() == 0)
            {
                response.sendRedirect("noDeviceFound.htm");
            }
        %>
       <h1 align="center">Mobile Device Allocation</h1>
       <hr size="5">
       <p align="center">
            <b>Select Mobile Device to be allocated</b>
       </p>
       <form:form commandName="adBean" method="post">
            <table border="0" align="center">
               <tbody>
                   <tr bgcolor="#00FFFF">
                       <td colspan="3" align="left"><b>Verifier Details</b></td>
                   </tr>
                   <tr>
                       <td>First Name :</td>
                       <td><spring:message text="${adBean.firstName}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Middle Name :</td>
                       <td><spring:message text="${adBean.middleName}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Last Name :</td>
                       <td><spring:message text="${adBean.lastName}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Date of Birth :</td>
                       <td><spring:message text="${adBean.dob}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Email :</td>
                       <td><spring:message text="${adBean.email}"/></td>
                       <td></td>
                   </tr>
                   <tr bgcolor="#00FFFF">
                       <td colspan="3" align="left"><b>Device Details</b></td>
                   </tr>
                   <tr>
                       <td>Device IMEI:</td>
                       <td><form:select path="imei">
                            <form:options items="${unallocatedDeviceList}" itemValue="imei" itemLabel="imei" />
                        </form:select></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td align="right"><input type="reset" value="Reset"/></td>
                       <td align="right">
                           <input type="submit" value="Back" name="_target2"/>
                           <input type="submit" value="Cancel" name="_target4"/>
                       </td>
                       <td align="left">
                           <input type="submit" value="Allocate" name="_finish"/>
                       </td>
                   </tr>
               </tbody>
           </table>
       </form:form>
       <hr size="5">
    </body>
</html>
