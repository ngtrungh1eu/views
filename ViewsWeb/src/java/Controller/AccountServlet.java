/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Registration.AccountsDAO;
import Registration.CartsDTO;
import Registration.HistoryOderDTO;
import Registration.OrdersDAO;
import Registration.ProductsDAO;
import Registration.ProductsDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ROG
 */
public class AccountServlet extends HttpServlet {

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
        String id = request.getParameter("id");
        String email = null;
        String password = null;
        String url = "account.jsp";
        try {
            ProductsDAO dao = new ProductsDAO();
            List<ProductsDTO> list = dao.getList(null, null, null);
            Cookie[] arr = request.getCookies();
            String txtCookie = "";
            if (arr != null) {
                for (Cookie o : arr) {
                    if (o.getName().equals("cart")) {
                        txtCookie += o.getValue();
                    }
                }
            }
            CartsDTO cart = new CartsDTO(txtCookie, list);
            request.setAttribute("cart", cart);
            AccountsDAO Adao = new AccountsDAO();
            OrdersDAO oderdao = new OrdersDAO();
            List<HistoryOderDTO> history = oderdao.historyoder(id);
            int historysize = history.size();
            request.setAttribute("history", history);
            request.setAttribute("Hsize", historysize);
            HttpSession session = request.getSession();
            session.setAttribute("AccountP", Adao.checklogin(email, password, id));
        } catch (SQLException e) {
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
