/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Registration.AccountsDAO;
import Registration.AccountsDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ACER
 */
public class UserManager extends HttpServlet {

    /**
<<<<<<< HEAD
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
=======
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
>>>>>>> ea1a47ad0ceb09795d2d5db45e6750f63f971343
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String buttion = request.getParameter("btAction");
<<<<<<< HEAD
        String url = "productmanager.jsp";
=======
        String url = "accountmanager.jsp";
>>>>>>> ea1a47ad0ceb09795d2d5db45e6750f63f971343
        AccountsDAO acc = new AccountsDAO();

        if (buttion.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));

            acc.delete(id);
<<<<<<< HEAD
                try {
                    request.setAttribute("UserList", acc.getList());
                } catch (SQLException ex) {

                }
            }

        

            try {
                request.setAttribute("UserList", acc.getList());
            } catch (SQLException ex) {
                Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        
=======
            try {
                request.setAttribute("UserList", acc.getList());
            } catch (SQLException ex) {

            }
        }

        try {
            request.setAttribute("UserList", acc.getList());
        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
>>>>>>> ea1a47ad0ceb09795d2d5db45e6750f63f971343

//        try {
//            AccountsDAO acc = new AccountsDAO();
//            request.setAttribute("UserList", acc.getList());
//        } catch (Exception e) {
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
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
