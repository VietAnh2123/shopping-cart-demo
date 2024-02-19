/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.Item;
import model.Product;

/**
 *
 * @author AD
 */
public class AddToCartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddToCartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddToCartServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
            HttpSession session = request.getSession();

            Object o = session.getAttribute("cart");
            Cart cart = new Cart();
            if (o != null) {
                cart = (Cart) o;
            }

            int pId = Integer.parseInt(request.getParameter("id"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            ProductDAO pDAO = new ProductDAO();
            Product product = pDAO.getProductById(pId);

            Item item = new Item(product, quantity);
            cart.addItem(item);
            session.setAttribute("cart", cart);
            response.sendRedirect("MyEShop.jsp");
//            request.getRequestDispatcher("MyEShop.jsp").forward(request, response);
            
            List<Item> list = cart.getItems();
            
            session.setAttribute("size", list.size());
        } catch (Exception e) {
            System.out.println("errrrrrrr");
            e.printStackTrace();
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
//        HttpSession session = request.getSession(true);
//        Cart cart;
//        Object o = session.getAttribute("cart");
//        
//        String quantity_raw = request.getParameter("quantity");
//        String id_raw = request.getParameter("id");
//        int quantity, id;
//        if (o != null) {
//            cart = (Cart) o;
//        } else {
//            cart = new Cart();
//        }
//        try {
//            quantity = Integer.parseInt(quantity_raw);
//            id = Integer.parseInt(id_raw);
//
//            ProductDAO pDAO = new ProductDAO();
//            Product p = pDAO.getProductById(id);
//            float price = (float) (p.getPrice() * 1.2);
//
//            Item item = new Item(p, quantity, price);
//            cart.addItem(item);
//        } catch (NumberFormatException e) {
//            quantity = 1;
//            e.printStackTrace();
//        }
//        List<Item> list = cart.getItems();
//        session.setAttribute("cart", cart);
//        session.setAttribute("size", list.size());
//        request.getRequestDispatcher("MyEShop.jsp").forward(request, response);

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
