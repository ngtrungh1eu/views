/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Registration.AccountsDAO;
<<<<<<< HEAD
import Registration.AccountsDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
=======
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
>>>>>>> ea1a47ad0ceb09795d2d5db45e6750f63f971343
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD

/**
 *
 * @author ACER
=======
import javax.servlet.http.HttpSession;

/**
 *
 * @author khong
>>>>>>> ea1a47ad0ceb09795d2d5db45e6750f63f971343
 */
public class ProfileAccount extends HttpServlet {

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
<<<<<<< HEAD
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
=======
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
>>>>>>> ea1a47ad0ceb09795d2d5db45e6750f63f971343
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        String url = "account.jsp";
        String newfirstname = request.getParameter("txtFirstname");
        System.out.println(newfirstname);
        String newlastname = request.getParameter("txtLastname");
        String newgender = request.getParameter("gender");
        String newphone = request.getParameter("txtPhone");
        String email = (String) request.getSession().getAttribute("txtEmail");
        String password = (String) request.getSession().getAttribute("txtPassword");
        String id = "";
        AccountsDAO dao = new AccountsDAO();
        //              AccountsDTO result = dao.checklogin(email, password, id);
//            if (result != null) {
        dao.updateAccount(id, email, password, newfirstname, newlastname, null, null, null, newphone, newgender, "user");
<<<<<<< HEAD
        request.setAttribute("txtFirstname", newfirstname);
        request.setAttribute("txtLastname", newlastname);
        request.setAttribute("txtPhone", newphone);
        request.setAttribute("gender", newgender);
=======
//        request.setAttribute("txtFirstname", newfirstname);
//        request.setAttribute("txtLastname", newlastname);
//        request.setAttribute("txtPhone", newphone);
//        request.setAttribute("gender", newgender);

        HttpSession session = request.getSession();
        try {
            session.setAttribute("AccountP", dao.checklogin(email, password, id));
        } catch (SQLException ex) {
            Logger.getLogger(ProfileAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        
>>>>>>> ea1a47ad0ceb09795d2d5db45e6750f63f971343
//            }
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
        out.close();
<<<<<<< HEAD

=======
>>>>>>> ea1a47ad0ceb09795d2d5db45e6750f63f971343
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
