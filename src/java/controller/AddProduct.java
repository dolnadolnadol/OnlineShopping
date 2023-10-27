/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CartTable;
import model.Products;
import model.ProductsTable;
import model.Shoppingcart;

/**
 *
 * @author cld
 */
public class AddProduct extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.InterruptedException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InterruptedException {
        Shoppingcart cart = new Shoppingcart();        
        List<Shoppingcart> lst = new ArrayList<Shoppingcart>();
        
        HttpSession session = request.getSession();
        try{
//            if(session.isNew()){
//                session.setAttribute("errmsg", "session END");
//                request.getRequestDispatcher("showerr_session.jsp").forward(request, response);
//            }else{
                session = request.getSession();
                int lastid = CartTable.lastId();
                Enumeration<String> parameterNames = request.getParameterNames();
                while (parameterNames.hasMoreElements()) {
                    String paramName = parameterNames.nextElement();
                    if (paramName.startsWith("check_")) {
                        
                        // A checkbox with name starting with "product_" was checked
                        String productId = paramName.substring("check_".length());
                        String quantityParam = "quantity_" + productId;
                        String quantity = request.getParameter(quantityParam);
                        if(quantity.equals("")){
                            continue;
                        }
                        Products pd = ProductsTable.findProductsById(Integer.parseInt(productId));
                        cart = new Shoppingcart(lastid+1,Integer.parseInt(productId));
                        cart.setProducts(pd);
                        cart.setQuantity(Integer.parseInt(quantity));
                        lst.add(cart);
                    }
//                }
                session.setAttribute("product",lst);
            }
        }
        finally{
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        }
               
    }   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InterruptedException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InterruptedException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
