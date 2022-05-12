/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.OrderItemDAO;
import DAO.OrdersDAO;
import DAO.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.OrderItem;
import model.Orders;

/**
 *
 * @author Admin
 */
public class CheckOutServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        if(session.getAttribute("user")==null){
            response.sendRedirect("login");
            return;
        }
        if(session.getAttribute("cart")==null){
            response.sendRedirect("home");
            return;
        }
        ArrayList<OrderItem> list = (ArrayList<OrderItem>) session.getAttribute("cart");
        request.setAttribute("cart", list);
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
        
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
        processRequest(request, response);
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
        HttpSession session = request.getSession();
        if(session.getAttribute("user")==null||session.getAttribute("cart")==null){
            response.sendRedirect("login");
            return;
        }
        Customer customer = (Customer) session.getAttribute("user");
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

        Orders order = new Orders(customer.getCustomerID(), 
        request.getParameter("firstname"), 
        request.getParameter("lastname"), 
        request.getParameter("email"), 
        request.getParameter("phone"), 
        request.getParameter("address"), 
        timeStamp, 
        "pending_"+request.getParameter("payment"), 
        Float.parseFloat(request.getParameter("total")));
        OrdersDAO dao = new OrdersDAO();
        dao.addOrder(order);
        int orderID = dao.returnOrderID(order);
        ArrayList<OrderItem> list = (ArrayList<OrderItem>) session.getAttribute("cart");
        for(OrderItem item:list){
            OrderItemDAO dao2 = new OrderItemDAO();
            item.setOrderID(orderID);
            dao2.addItem(item);
            ProductDAO dao3 = new ProductDAO();
            dao3.updateQuantiry(item.getProductID(), item.getQuantity());
            session.setAttribute("cart",null);
        }
        String payment = request.getParameter("payment");
            if(payment.compareTo("cash")==0){
            response.sendRedirect("home");
        }
        else request.getRequestDispatcher("credit.jsp").forward(request, response);
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
