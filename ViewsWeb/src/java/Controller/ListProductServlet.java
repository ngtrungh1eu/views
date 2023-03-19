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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ROG
 */
public class ListProductServlet extends HttpServlet {

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

        String url = "list-products.jsp";
        try {
            int page, start, end, numperpage=9;
            String typeValue = request.getParameter("type");
            String brandValue = request.getParameter("brand");
            String searchValue = request.getParameter("txtSearch");
            String minPrice = request.getParameter("minPrice");
            String maxPrice = request.getParameter("maxPrice");
            String xpage = request.getParameter("page");
            ProductsDAO dao = new ProductsDAO();
            List<ProductsDTO> list = dao.getList(brandValue, typeValue, searchValue);
            int sizeProduct = list.size();
            Cookie[] arr = request.getCookies();
            String txtCookie = "";
            if (arr != null) {
                for (Cookie o : arr) {
                    if (o.getName().equals("cart")) {
                        txtCookie += o.getValue();
                    }
                }
            }
            List<ProductsDTO> listcart = dao.load();
            int size= list.size();
            int num = (size%9==0?(size/9):((size/9))+1);
            CartsDTO cart = new CartsDTO(txtCookie, listcart);
            request.setAttribute("cart", cart);
            List<ItemsDTO> listItem = cart.getItems();
            int n;
            if (listItem != null) {
                n = listItem.size();
            } else {
                n = 0;
            }
            
            if(xpage==null){
                page = 1;
            }else{
                page = Integer.parseInt(xpage);
            }
            start = (page-1)*numperpage;
            end= Math.min((page*numperpage), size);
            List<ProductsDTO> listpage = dao.getListByPage(list, start, end);
            request.setAttribute("ListP", listpage);
            request.setAttribute("sizeViews", sizeProduct);
            request.setAttribute("page", page);
            request.setAttribute("num", num);
            request.setAttribute("size", n);

            if (minPrice != null || maxPrice != null) {
                dao = new ProductsDAO();
                request.setAttribute("ListP", dao.getListByPrice(minPrice, maxPrice));
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
