<%-- 
    Document   : showerr_session
    Created on : Oct 27, 2023, 1:32:10 PM
    Author     : cld
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Shopping[ERR]</title>
    </head>
    <body>
        <%
            if(session==null){
                out.println("<h1>ERR</h1>");
            }else{
                String msg = (String) session.getAttribute("errmsg");
                out.println("<h1>"+msg+"</h1>");
            }
            session.invalidate();
            
        %>
        <form action="productCatalog.jsp">
            <input type = "submit" value = "BACK" name = "back"/>
        </form>
        
    </body>
</html>
