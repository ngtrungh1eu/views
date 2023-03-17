/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Registration.CartsDTO;
import Registration.ItemsDTO;
import Registration.ProductsDAO;
import Registration.ProductsDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author khong
 */
@WebServlet(name = "ProductDetailServlet", urlPatterns = {"/productdetail"})
public class ProductDetailServlet extends HttpServlet {

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
        String url = "productdetail.jsp";
        String pId = request.getParameter("pId");
        String typeValue = request.getParameter("type");
        String brandValue = request.getParameter("brand");
        String searchValue = request.getParameter("txtSearch"); 

        try {
        ProductsDAO dao = new ProductsDAO();
        List<ProductsDTO> list = dao.getList(brandValue, typeValue, searchValue);
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
        List<ItemsDTO> listItem = cart.getItems();
        int n;
        if (listItem != null) {
            n = listItem.size();
        } else {
            n = 0;
        }
            request.setAttribute("pDetail", dao.getProduct(pId));
            request.setAttribute("size", n);
            request.setAttribute("ListP", list);
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
