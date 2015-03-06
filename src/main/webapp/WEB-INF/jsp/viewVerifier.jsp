<%-- 
    Document   : viewVerifier
    Created on : 22-Sep-2010, 10:12:16
    Author     : Miroslav
--%>

<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.io.OutputStream"%>
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
        <title>HafTrust Verify Verifier Details Page</title>
    </head>
    <body>
       <h1 align="center">Verifier Verification</h1>
       <hr size="5">
       <p align="center">
            <b>Verify Verifier's Details</b>
       </p>
       <form:form commandName="vvBean" method="post">
            <table border="0" align="center">
               <tbody>
                   <tr bgcolor="#00FFFF">
                       <td colspan="3" align="left"><b>Personal Details</b></td>
                   </tr>
                   <tr>
                       <td>First Name : </td>
                       <td><spring:message text="${vvBean.firstName}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Middle Name : </td>
                       <td><spring:message text="${vvBean.middleName}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Last Name : </td>
                       <td><spring:message text="${vvBean.lastName}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Telephone Number :</td>
                       <td><spring:message text="${vvBean.telephoneNumber}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Gender :</td>
                       <td><spring:message text="${vvBean.gender}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Date of Birth :</td>
                       <td><spring:message text="${vvBean.dob}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Email :</td>
                       <td><spring:message text="${vvBean.email}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Education Level : </td>
                       <td><spring:message text="${vvBean.educationLevel}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Education Type : </td>
                       <td><spring:message text="${vvBean.educationType}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Verification Status :</td>
                       <td><form:select path="verifierVerificationStatus">
                            <form:options items="${verificationStatusList}" itemValue="value" itemLabel="description" />
                        </form:select></td>
                       <td><form:errors path="verifierVerificationStatus" cssClass="error"/></td>
                   </tr>
                   <tr>
                       <td>Verification Comment :</td>
                       <td><form:textarea path="verifierVerificationComment" rows="3" cols="15"/></td>
                       <td><form:errors path="verifierVerificationStatus" cssClass="error"/></td>
                   </tr>
                   <tr bgcolor="#00FFFF">
                       <td colspan="3" align="left"><b>Address Details</b></td>
                   </tr>
                   <tr>
                       <td>Street :</td>
                       <td><spring:message text="${vvBean.street}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Village :</td>
                       <td><spring:message text="${vvBean.village}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Postcode :</td>
                       <td><spring:message text="${vvBean.postcode}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Town :</td>
                       <td><spring:message text="${vvBean.town}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>City :</td>
                       <td><spring:message text="${vvBean.city}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>District :</td>
                       <td><spring:message text="${vvBean.district}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Region :</td>
                       <td><spring:message text="${vvBean.addressRegion}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Country :</td>
                       <td><spring:message text="${vvBean.addressCountry}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Verification Status :</td>
                       <td><form:select path="addressVerificationStatus">
                            <form:options items="${verificationStatusList}" itemValue="value" itemLabel="description" />
                        </form:select></td>
                       <td><form:errors path="addressVerificationStatus" cssClass="error"/></td>
                   </tr>
                   <tr>
                       <td>Verification Comment :</td>
                       <td><form:textarea path="addressVerificationComment" rows="3" cols="15"/></td>
                       <td><form:errors path="addressVerificationStatus" cssClass="error"/></td>
                   </tr>
                   <tr bgcolor="#00FFFF">
                       <td colspan="3" align="left"><b>Personal Photo</b></td>
                   </tr>
                   <tr>
                      <td>Photo : </td>
                      <td>
                          <!-- XHTML or JSP -->
                          <!-- TODO fix having to supply .htm in the URL -->
                            <img src="image.htm?id=<%=((VerifyVerifierBean) request.getAttribute("vvBean")).getImage().getId() %>" />


                          
                          <%
                            //java.awt.Image i = ((VerifyVerifierBean) request.getAttribute("vvBean")).getFileBi().getScaledInstance(((VerifyVerifierBean) request.getAttribute("vvBean")).getFileBi().getWidth(),
                                                                                                                                   //((VerifyVerifierBean) request.getAttribute("vvBean")).getFileBi().getHeight(),
                                                                                                                                   //((VerifyVerifierBean) request.getAttribute("vvBean")).getFileBi().TYPE_INT_RGB );
                            /*try {

                                    // display the image
                                    //response.setContentType("text/html");

                                    OutputStream o = response.getOutputStream();

                                    o.write(((VerifyVerifierBean) request.getAttribute("vvBean")).getFile());

                                    o.flush();

                                    o.close();

                                    } catch (Exception e) {

                                    out.println("Unable To Display image");

                                    out.println("Image Display Error=" + e.getMessage());

                                    return;

                                    }*/
                          %>
                          <%--<img src="<%= i %>" alt="Image"/>--%>
                      </td>
                      <td></td>
                  </tr>
                  <tr>
                       <td>Verification Status :</td>
                       <td><form:select path="fileVerificationStatus">
                            <form:options items="${verificationStatusList}" itemValue="value" itemLabel="description" />
                        </form:select></td>
                       <td><form:errors path="fileVerificationStatus" cssClass="error"/></td>
                   </tr>
                   <tr>
                       <td>Verification Comment :</td>
                       <td><form:textarea path="fileVerificationComment" rows="3" cols="15"/></td>
                       <td><form:errors path="fileVerificationStatus" cssClass="error"/></td>
                   </tr>
                   <tr bgcolor="#00FFFF">
                       <td colspan="3" align="left"><b>Identity Document Details</b></td>
                   </tr>
                   <tr>
                       <td>Document Type :</td>
                       <td><spring:message text="${vvBean.identityDocumentType}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Number :</td>
                       <td><spring:message text="${vvBean.identityDocumentNumber}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Issue Date :</td>
                       <td><spring:message text="${vvBean.identityDocumentIssueDate}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Expiry Date :</td>
                       <td><spring:message text="${vvBean.identityDocumentExpiryDate}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Verification Status :</td>
                       <td><form:select path="identityDocumentVerificationStatus">
                            <form:options items="${verificationStatusList}" itemValue="value" itemLabel="description" />
                        </form:select></td>
                       <td><form:errors path="identityDocumentVerificationStatus" cssClass="error"/></td>
                   </tr>
                   <tr>
                       <td>Verification Comment :</td>
                       <td><form:textarea path="identityDocumentVerificationComment" rows="3" cols="15"/></td>
                       <td><form:errors path="identityDocumentVerificationStatus" cssClass="error"/></td>
                   </tr>
                   <tr bgcolor="#00FFFF">
                       <td colspan="3" align="left"><b>Account Details</b></td>
                   </tr>
                   <tr>
                       <td>Account Number :</td>
                       <td><spring:message text="${vvBean.bankAccountNumber}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Bank Name :</td>
                       <td><spring:message text="${vvBean.bankName}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Telephone :</td>
                       <td><spring:message text="${vvBean.bankContactNumber}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Bank Address :</td>
                       <td><spring:message text="${vvBean.bankAddress}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>SortCode : </td>
                       <td><spring:message text="${vvBean.bankSortCode}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>IBAN :</td>
                       <td><spring:message text="${vvBean.bankIban}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Verification Status :</td>
                       <td><form:select path="bankVerificationStatus">
                            <form:options items="${verificationStatusList}" itemValue="value" itemLabel="description" />
                        </form:select></td>
                       <td><form:errors path="bankVerificationStatus" cssClass="error"/></td>
                   </tr>
                   <tr>
                       <td>Verification Comment :</td>
                       <td><form:textarea path="bankVerificationComment" rows="3" cols="15"/></td>
                       <td><form:errors path="bankVerificationStatus" cssClass="error"/></td>
                   </tr>
                   <tr bgcolor="#00FFFF">
                       <td colspan="3" align="left"><b>Reference 1 Details</b></td>
                   </tr>
                   <tr>
                       <td>Title :</td>
                       <td><spring:message text="${vvBean.reference1Title}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Full Name :</td>
                       <td><spring:message text="${vvBean.reference1FullName}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Organisation Name :</td>
                       <td><spring:message text="${vvBean.reference1OrganisationName}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Designation :</td>
                       <td><spring:message text="${vvBean.reference1Designation}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Telephone :</td>
                       <td><spring:message text="${vvBean.reference1ContactNumber}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Email :</td>
                       <td><spring:message text="${vvBean.reference1Email}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Address :</td>
                       <td><spring:message text="${vvBean.reference1Address}"/></td>
                       <td></td>
                   </tr>
                    <tr>
                       <td>Verification Status :</td>
                       <td><form:select path="reference1VerificationStatus">
                            <form:options items="${verificationStatusList}" itemValue="value" itemLabel="description" />
                        </form:select></td>
                       <td><form:errors path="reference1VerificationStatus" cssClass="error"/></td>
                   </tr>
                   <tr>
                       <td>Verification Comment :</td>
                       <td><form:textarea path="reference1VerificationComment" rows="3" cols="15"/></td>
                       <td><form:errors path="reference1VerificationStatus" cssClass="error"/></td>
                   </tr>
                   <tr bgcolor="#00FFFF">
                       <td colspan="3" align="left"><b>Reference 2 Details</b></td>
                   </tr>
                   <tr>
                       <td>Title :</td>
                       <td><spring:message text="${vvBean.reference2Title}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Full Name :</td>
                       <td><spring:message text="${vvBean.reference2FullName}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Organisation Name :</td>
                       <td><spring:message text="${vvBean.reference2OrganisationName}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Designation :</td>
                       <td><spring:message text="${vvBean.reference2Designation}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Telephone :</td>
                       <td><spring:message text="${vvBean.reference2ContactNumber}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Email :</td>
                       <td><spring:message text="${vvBean.reference2Email}"/></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td>Address :</td>
                       <td><spring:message text="${vvBean.reference2Address}"/></td>
                       <td></td>
                   </tr>
                    <tr>
                       <td>Verification Status :</td>
                       <td><form:select path="reference2VerificationStatus">
                            <form:options items="${verificationStatusList}" itemValue="value" itemLabel="description" />
                        </form:select></td>
                       <td><form:errors path="reference2VerificationStatus" cssClass="error"/></td>
                   </tr>
                   <tr>
                       <td>Verification Comment :</td>
                       <td><form:textarea path="reference2VerificationComment" rows="3" cols="15"/></td>
                       <td><form:errors path="reference2VerificationStatus" cssClass="error"/></td>
                   </tr>
                   <tr>
                       <td colspan="3" align="center"><b>Select Field Operative Manager to conduct an Interview</b></td>
                   </tr>
                   <tr bgcolor="#00FFFF">
                       <td colspan="3" align="left"><b>Field Operative Manager Details</b></td>
                   </tr>
                   <tr>
                       <td>Field Operative Manager : </td>
                       <td><form:select path="idFom">
                               <form:options items="${vvBean.fBean}" itemValue="id" itemLabel="label"/>
                        </form:select></td>
                       <td></td>
                   </tr>
                   <tr>
                       <td align="right"><input type="reset" value="Reset"/></td>
                       <td align="right">
                           <input type="submit" value="Cancel" name="_target4"/>
                           <input type="submit" value="Delete" name="_target5"/>
                       </td>
                       <td align="left">
                           <input type="submit" value="Back" name="_target2"/>
                           <input type="submit" value="Verify" name="_finish"/>
                       </td>
                   </tr>
               </tbody>
           </table>
       </form:form>
       <hr size="5">
    </body>
</html>
