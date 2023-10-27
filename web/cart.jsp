<%-- 
    Document   : cart
    Created on : Oct 23, 2023, 4:25:19 PM
    Author     : cld
--%>

<%@page import="model.Products"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.CartTable"%>
<%@page import="model.ProductsTable"%>
<%@page import="java.util.List"%>
<%@page import="model.Shoppingcart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Shopping[Cart]</title>
    </head>
    <jsp:useBean id="emp" class="model.Shoppingcart" scope="request"/>
     <%
            List<Shoppingcart> sc = (List<Shoppingcart>)session.getAttribute("product");
            Iterator<Shoppingcart> itr = sc.iterator();
     %>
    <body>
        <center>
        <h1>Shopping Cart</h1>
        <form action="Confirmaddcart" method="POST">
            <table border="1" cellspacing="2" cellpadding="2">
                <thead>
                    <tr>
                        <th>DVD Names</th>
                        <th>Rate</th>
                        <th>Year</th>
                        <th>Price/Unit</th>
                        <th>Quantity</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                        <%
                            int total = 0;
                            while(itr.hasNext()) {
                                emp = itr.next();
                                out.println("<tr>");
                                out.println("<td>"+ emp.getProducts().getMovie() + "</td>");
                                out.println("<td> "+ emp.getProducts().getRating() + "</td>");
                                out.println("<td> "+ emp.getProducts().getYearcreate() + "</td>");
                                out.println("<td> "+ emp.getProducts().getPrice() + "</td>");
                                out.println("<td> "+ emp.getQuantity() + "</td>");
                                out.println("<td>"+emp.getProducts().getPrice()*emp.getQuantity()+"</td>");
                                out.println("<tr>");
                                total += (emp.getProducts().getPrice()*emp.getQuantity());
                            }
                        %>
                        <input type="hidden" name="total" value="<%= total %>">
                        <tr>
                            <td colspan="5" style="text-align: center">Total</td>
                            <td><%out.println(total);%></td>
                        </tr>
                    </tbody>
                </table>
                <input type="submit" value="Check out" name="checkout" />
            </form>
    </body>
</html>
