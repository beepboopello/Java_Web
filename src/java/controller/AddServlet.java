/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ProductDAO;
import DAO.StoreAvailableDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import model.Seller;
import model.StoreAvailable;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddServlet", urlPatterns = {"/add"})
public class AddServlet extends HttpServlet {

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
//        String pid =request.getParameter("aid");
//        int id;
//        id=Integer.parseInt(pid);
        int pid = Integer.parseInt(request.getParameter("aid"));
        String pn = request.getParameter("an");
        String pca = request.getParameter("acate");
        String pb = request.getParameter("ab");
        String pco = request.getParameter("acolor");
        String ps = request.getParameter("as");
//        String x = request.getParameter("ap");
//        float pp;
//        pp=Float.parseFloat(x);
        float pp = Float.parseFloat(request.getParameter("ap"));
        String pd = request.getParameter("ades");
        String pi = request.getParameter("ai");
        String pq = request.getParameter("aq");
        
        
        Product p = new Product(pid, pn, pca, pb, pco, ps, pp, pd, pi);
        ProductDAO dao = new ProductDAO();
        dao.addProduct(p);
        
        StoreAvailable sa = new StoreAvailable(1, pid, Integer.parseInt(pq));
        StoreAvailableDAO sdao = new StoreAvailableDAO();
        sdao.addStoreAvailable(sa);
        
        
        response.sendRedirect("admin");
//        request.getRequestDispatcher("admin").forward(request, response);
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
        processRequest(request, response);
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
