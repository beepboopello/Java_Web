/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import model.Product;

/**
 *
 * @author Admin
 */
@WebServlet(name = "LoadProInShop", urlPatterns = {"/loadshop"})
public class LoadProInShop extends HttpServlet {

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
        ProductDAO dao=new ProductDAO();
        List<Product> list1 = new ArrayList<>();
        list1= dao.getPlist();
        request.setAttribute("listc", list1);
        request.getRequestDispatcher("shop.jsp").forward(request, response);
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
        String sql = "SELECT * FROM dbo.product WHERE 1=1 ";
        String part;
        if(request.getParameter("price-all")==null){
            part = ""; 
            if(request.getParameter("price-1")!=null) part+= " OR price BETWEEN 0 AND 50000 ";
            if(request.getParameter("price-2")!=null) part+= " OR price BETWEEN 50000 AND 200000 ";
            if(request.getParameter("price-3")!=null) part+= " OR price BETWEEN 200000 AND 500000 ";
            if(request.getParameter("price-4")!=null) part+= " OR price BETWEEN 500000 AND 1000000 ";
            if(request.getParameter("price-5")!=null) part+= " OR price > 1000000";
            if(!part.isEmpty()) sql+= "AND (1=0" +part+") ";
        }
        if(request.getParameter("color-all")==null){
            part = ""; 
            if(request.getParameter("color-black")!=null) part+= " OR color = 'Black' ";
            if(request.getParameter("color-white")!=null) part+= " OR color = 'White' ";
            if(request.getParameter("color-red")!=null) part+= " OR color = 'Red' ";
            if(request.getParameter("color-blue")!=null) part+= " OR color = 'Blue' ";
            if(request.getParameter("color-green")!=null) part+= " OR color = 'Green'";
            if(!part.isEmpty()) sql+= "AND (1=0" +part+") ";
        }
        if(request.getParameter("size-all")==null){
            part = ""; 
            if(request.getParameter("size-XS")!=null) part+= " OR size = 'XS' ";
            if(request.getParameter("size-S")!=null) part+= " OR size = 'S' ";
            if(request.getParameter("size-M")!=null) part+= " OR size = 'M' ";
            if(request.getParameter("size-L")!=null) part+= " OR size = 'L' ";
            if(request.getParameter("size-XL")!=null) part+= " OR size = 'XL' ";
            if(request.getParameter("size-XXL")!=null) part+= " OR size = 'XXL' ";
            if(request.getParameter("size-XXXL")!=null) part+= " OR size = 'XXXL' ";
            if(!part.isEmpty()) sql+= "AND (1=0" +part+") ";
        }
        System.out.println(sql);
        List<Product> list1 = new ArrayList<>();
        ProductDAO dao=new ProductDAO();
        list1= dao.getListFromQuery(sql);
        request.setAttribute("listc", list1);
System.out.println(list1.size());
        request.getRequestDispatcher("shop.jsp").forward(request, response);
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
