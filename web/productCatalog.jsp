<%-- 
    Document   : productCatalog
    Created on : Oct 23, 2023, 3:04:43 AM
    Author     : cld
--%>

<%@page import="model.ProductsTable"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.Products"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Shopping</title>
    </head>
    <jsp:useBean id="emp" class="model.Products" scope="request"/>
     <%
                       
            List<Products> empList = ProductsTable.findAllProducts();
            Iterator<Products> itr = empList.iterator();
            
     %>
    <body>
        <center>
        <h1>DVD Catalog</h1>
        <form action="AddProduct" method="POST">
            <table border="1" cellspacing="2" cellpadding="2">
                <thead>
                    <tr>
                        <th>DVD Names</th>
                        <th>Rate</th>
                        <th>Year</th>
                        <th>Price</th>
                        <th>Quantity</th>
                    </tr>
                </thead>
                <tbody>
                        <%
                            session = request.getSession();
                            while(itr.hasNext()) {
                                emp = itr.next();
                                out.println("<tr>");
                                out.println("<td> <input type=\"checkbox\" name=\"check_"+emp.getId()+"\" value=\"ON\" />"+ emp.getMovie() + "</td>");
                                out.println("<td> "+ emp.getRating() + "</td>");
                                out.println("<td> "+ emp.getYearcreate() + "</td>");
                                out.println("<td> "+ emp.getPrice() + "</td>");
                                out.println("<td><input type=\"text\" name=\"quantity_"+emp.getId()+"\" value=\"\"/></td>");
                                out.println("<tr>");
                            }
                        %>                
                </tbody>  
            </table>
            <input type="submit" value="Add to Cart" name="add" />   
        </form>
    </body>
</html>
