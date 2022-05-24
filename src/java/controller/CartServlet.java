/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.OrderItem;
import model.Orders;
import model.Product;

/**
 *
 * @author Acer
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {

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
        ProductDAO dao = new ProductDAO();
        HttpSession session = request.getSession();
        if(session.getAttribute("user")==null){
            response.sendRedirect("login"); 
        } 
        else{
        List<OrderItem> list = (List<OrderItem>) session.getAttribute("cart");
        String pid = request.getParameter("pid");
        if (pid == null){
        return;}
        OrderItem items = new OrderItem();
        Product p = dao.getP(pid);
        items.setProductID(p.getProductID());
        items.setPrice(p.getPrice());
        items.setDiscount(p.getDiscount());
        items.setName(p.getName());
        items.setImg(p.getImage());
        String quantity = request.getParameter("quantity");
        if(quantity==null) quantity = "1";
        if(Integer.parseInt(quantity)>dao.getQuantity(pid)){
            return;
        }
        items.setQuantity(Integer.parseInt(quantity));
        if(list==null){
            list = new ArrayList<>();
            list.add(items);
        }else{
        boolean itemInList=false;
        for(OrderItem item : list){
            if(item.getProductID()==items.getProductID()){
                if(dao.getQuantity(pid)<item.getQuantity()+items.getQuantity()){
                    return;
                }
                item.setQuantity(item.getQuantity()+items.getQuantity());
                System.out.println("Order this amount: " + item.getQuantity());
                if(dao.getQuantity(pid)<item.getQuantity()){
                    return;
                }
                itemInList=true;
            }
        }
        System.out.println("hello khang");
        if(!itemInList) list.add(items);}
        session.setAttribute("cart", list);
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
        response.setContentType("text/html;charset=UTF-8");
            HttpSession session = request.getSession();
            if(session.getAttribute("user")==null){
                response.sendRedirect("login");
                return;
            }
        ArrayList<OrderItem> list = (ArrayList<OrderItem>) session.getAttribute("cart");
        request.setAttribute("cart", list);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
        
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
        if(request.getParameter("itemid")!=null){
            ArrayList<OrderItem> list = (ArrayList<OrderItem>) session.getAttribute("cart");
            for(OrderItem item:list){
                if(item.getItemID()== Integer.parseInt(request.getParameter("itemid"))){
                    list.remove(item);
                    break;
                }
            }
            if(list.isEmpty()){
                response.sendRedirect("home");
                return;
            }
            request.setAttribute("cart", list);
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        }else
        processRequest(request, response);
    }
//
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
