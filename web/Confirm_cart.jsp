<%-- 
    Document   : Confirm_cart
    Created on : Oct 27, 2023, 1:12:44 PM
    Author     : cld
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Shopping[CART]</title>
    </head>
    <body>
        <%
            String tt = (String) session.getAttribute("Total");
        %>
        <h1>Your Order is confirmed!</h1>
        <%
            if(session.isNew()){
                request.setAttribute("errmsg", "SESSION END");
                request.getRequestDispatcher("showerr_session.jsp");
            }
            out.println("<h2>The Total Amount is "+ tt +"$</h2>");
            session.invalidate();
        %>
        <form action="productCatalog.jsp">
            <input type = "submit" value = "BACK" name = "back"/>
        </form>
    </body>
</html>
