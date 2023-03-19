
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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ROG
 */
public class SigninServlet extends HttpServlet {

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
//        PrintWriter out = response.getWriter();
//        String url = "";
//        String email = request.getParameter("txtEmail");
//        String password = request.getParameter("txtPassword");
//        String id = null;
//        try {
//            AccountsDAO dao = new AccountsDAO();
//            AccountsDTO result = dao.checklogin(email, password, id);
//            if (result != null) {
//                url = "home.jsp";
//                HttpSession session = request.getSession();
//                session.setAttribute("Account", result);
//                System.out.println(result);
//            } else {
//                request.setAttribute("mess", "Wrong Email or Password");
//                url = "signin.jsp";
//            }
//        } catch (SQLException ex) {
//        } finally {
//            RequestDispatcher rd = request.getRequestDispatcher(url);
//            rd.forward(request, response);
//            out.close();
//        }
//    }

        PrintWriter out = response.getWriter();
        String url = "";
        String email = request.getParameter("txtEmail");
        String password = request.getParameter("txtPassword");

        String id = null;
        try {

            AccountsDAO dao = new AccountsDAO();
//                    
//            if (dao.checkAccess(email, password).getRole() != null &&dao.checkAccess(email, password).getRole().equals("Admin")) {
//                url = "productmanager.jsp";
//
//            }
            AccountsDTO result = dao.checklogin(email, password, id);

            request.getSession().setAttribute("txtEmail", email);
            request.getSession().setAttribute("txtPassword", password);
            //Toan code
            if (result != null) {
                if (result.getRole().equals("Admin")) {
                    url = "UserManager";
                    HttpSession session = request.getSession();
                    session.setAttribute("Account", result);
                    //Toan code
                } else if (result.getRole().equals("user")) {
                    url = "home.jsp";
                    HttpSession session = request.getSession();
                    session.setAttribute("Account", result);
                    System.out.println(result);
                }
            } else {
                request.setAttribute("mess", "Wrong Email or Password");
                url = "signin.jsp";
            }
        } catch (SQLException ex) {
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);

            rd.forward(request, response);
            out.close();
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
