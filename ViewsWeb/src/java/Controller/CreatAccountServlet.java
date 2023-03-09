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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ROG
 */
public class CreatAccountServlet extends HttpServlet {

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
        String url = "";
        try {
            int id = 0;
            String email = request.getParameter("txtNewEmail");
            String password = request.getParameter("txtNewPassword");
            String re_password = request.getParameter("txtReNewPassword");
            String gender = request.getParameter("NewGender");
            String dob = request.getParameter("DoB");
            String firstname = request.getParameter("txtNewFirstName");
            String lastname = request.getParameter("txtNewLastName");
            String country = null;
            String city = null;
            String phone = null;
            String role = "user";
            boolean check = false;
            if (!password.equals(re_password)) {
                url = "signup.jsp";
                request.setAttribute("Mess1", "Passwords are not the same");
            } else {
                AccountsDAO dao = new AccountsDAO();
                String MailChecked = dao.checkEmail(email);
<<<<<<< HEAD
                System.out.println(MailChecked);
                if (MailChecked == null) {
                    boolean rs = dao.addAccount(id, email, password, firstname, lastname, dob, country, city, phone, gender, role);
                    if (rs == true) {
                        url = "home.jsp";
=======
                if (!MailChecked.equals(email)) {
                    boolean rs = dao.addAccount(id,email, password, firstname, lastname, country, city, phone, gender, role);
                    if (rs == true) {
                        url = "home";
>>>>>>> main
                    } else {
                        url = "signup.jsp";
                    }
                } else {
                    url = "signup.jsp";
                }
            }
        } catch (Exception e) {
        }
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
