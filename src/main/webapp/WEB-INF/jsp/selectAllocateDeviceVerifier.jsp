<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
        <title>HafTrust Allocate Mobile Device - Select Verifier Page</title>
    </head>
    <body>
       <h1 align="center">Mobile Device Allocation</h1>
       <hr size="5">
       <p align="center">
            <b>Select Verifier</b>
        </p>
       <form:form commandName="adBean" method="post">
           <table border="0" align="center">
               <tbody>
                   <tr>
                       <td>Verifier : </td>
                       <td><form:select path="idVerifier">
                               <form:options items="${adBean.vBean}" itemValue="id" itemLabel="label"/>
                        </form:select></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td align="right"><input type="submit" value="Cancel" name="_target4"/></td>
                       <td align="right"><input type="submit" value="Back" name="_target1"/></td>
                       <td align="left"><input type="submit" value="Select" name="_target3"/></td>
                   </tr>
               </tbody>
           </table>
       </form:form>
       <hr size="5">
    </body>
</html>
