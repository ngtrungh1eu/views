/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Registration.ProductsDAO;
import Registration.ProductsDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author khong
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {

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
        String url = "productmanager.jsp";
        String action = request.getParameter("action");
        String txtSearch = request.getParameter("txtSearchProduct");
        ProductsDAO dao = new ProductsDAO();
        if (action == null || action.equals("list")) {
            try {
                dao = new ProductsDAO();
                List<ProductsDTO> list = dao.load(txtSearch);
                request.setAttribute("ListP", list);
            } catch (Exception e) {
            }
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } else if (action.equals("create")) {
            List<ProductsDTO> list = null;
            Long id = null;
            try {
                id = Long.parseLong(request.getParameter("product_id"));
            } catch (NumberFormatException ex) {

            }
            ProductsDTO product = null;
            request.setAttribute("action", "insert");
            RequestDispatcher rd = request.getRequestDispatcher("editproduct.jsp");
            rd.forward(request, response);

        } else if (action.equals("edit")) {
            Long id = null;
            try {
                id = Long.parseLong(request.getParameter("product_id"));
            } catch (NumberFormatException ex) {

            }
            ProductsDTO product = new ProductsDTO();
            dao = new ProductsDAO();
            if (id != null) {
                product = dao.load(id);
            }
            request.setAttribute("pDetails", product);
            request.setAttribute("action", "update");
            RequestDispatcher rd = request.getRequestDispatcher("editproduct.jsp");
            rd.forward(request, response);
        } else if (action.equals("delete")) {
            Long id = null;
            try {
                id = Long.parseLong(request.getParameter("product_id"));
            } catch (NumberFormatException ex) {

            }

            if (id != null) {
                dao.delete(id);
            }

            dao = new ProductsDAO();
            List<ProductsDTO> list = dao.load(txtSearch);
            request.setAttribute("ListP", list);
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);

        } else if (action.equals("insert")) {
            Long id = null;
            int pId = Integer.parseInt(request.getParameter("product_id"));
            String name = request.getParameter("product_name");
            String type = request.getParameter("type");
            double price = Double.parseDouble(request.getParameter("price"));
            String image = request.getParameter("image");
            int cate = Integer.parseInt(request.getParameter("product_categorie"));
            float saleoff = Float.parseFloat(request.getParameter("saleoff"));
            try {
                id = Long.parseLong(request.getParameter("product_id"));
            } catch (NumberFormatException ex) {
            }
            dao = new ProductsDAO();
            ProductsDTO product = new ProductsDTO();
            product.setProduct_id(pId);
            product.setProduct_name(name);
            product.setPrice(price);
            product.setImage(image);
            product.setCate_id(cate);
            product.setType(type);
            product.setSaleoff((int) saleoff);
            id = dao.insert(product);
            List<ProductsDTO> list = dao.load(txtSearch);
            request.setAttribute("ListP", list);
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } else if (action.equals("update")) {
            Long id = null;
            int pId = 0;
            String name = null;
            double price = 0;
            int cate = 0;
            String type = null;
            String image = null;
            float saleoff = 0;
            try {
                pId = Integer.parseInt(request.getParameter("product_id"));
                name = request.getParameter("product_name");
                type = request.getParameter("type");
                price = Double.parseDouble(request.getParameter("price"));
                image = request.getParameter("image");
                cate = Integer.parseInt(request.getParameter("product_categorie"));
                saleoff = Float.parseFloat(request.getParameter("saleoff"));
            } catch (Exception e) {
                System.out.println("loi me roi");
            }
            try {
                id = Long.parseLong(request.getParameter("product_id"));
            } catch (NumberFormatException ex) {

            }
            ProductsDTO product = new ProductsDTO();
            product.setProduct_id(pId);
            product.setProduct_name(name);
            product.setPrice(price);
            product.setImage(image);
            product.setCate_id(cate);
            product.setType(type);
            product.setSaleoff((int) saleoff);
            if (id != null) {
                product = dao.update(product);
            }
            request.setAttribute("pDetails", product);
            List<ProductsDTO> list = dao.load(txtSearch);
            request.setAttribute("ListP", list);
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
