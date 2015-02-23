<%-- 
    Document   : imageDisplay
    Created on : 30-Sep-2010, 00:29:57
    Author     : Miroslav
--%>

<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page  import="org.haftrust.verifier.view.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
<body>    
        <%
        try
                {
                // display the image
                response.setContentType("image/gif");

                OutputStream o = response.getOutputStream();

                o.write(((VerifyVerifierBean) request.getAttribute("vvBean")).getFile());

                o.flush();

                o.close();

                } catch(Exception e)
                    {

                        out.println("Unable To Display image");

                        out.println("Image Display Error=" + e.getMessage());

                        return;

                    }
          %>

           </body>
</html>
