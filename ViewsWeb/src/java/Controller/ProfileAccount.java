/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Registration.AccountsDAO;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author khong
 */
public class ProfileAccount extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        String url = "account.jsp";
        String newfirstname = request.getParameter("txtFirstname");
        System.out.println(newfirstname);
        String newlastname = request.getParameter("txtLastname");
        String newgender = request.getParameter("gender");
        String newphone = request.getParameter("txtPhone");
        String newDay = request.getParameter("txtDay");
        String newMonth = request.getParameter("txtMonth");
        String newYear = request.getParameter("txtYear");
        String Date = newYear + "-" + newMonth + "-" + newDay;
        String newCity = request.getParameter("txtCity");
        String newCountry = request.getParameter("txtCountry");
        String email = (String) request.getSession().getAttribute("txtEmail");
        String password = (String) request.getSession().getAttribute("txtPassword");
        String id = "";
        AccountsDAO dao = new AccountsDAO();
        //              AccountsDTO result = dao.checklogin(email, password, id);
//            if (result != null) {
        dao.updateAccount(id, email, password, newfirstname, newlastname, Date, newCountry, newCity, newphone, newgender, "user");
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

//            }
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
        out.close();

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
