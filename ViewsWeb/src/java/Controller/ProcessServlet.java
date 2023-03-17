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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ROG
 */
public class ProcessServlet extends HttpServlet {

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
        String action = request.getParameter("btAction");
        try {
        ProductsDAO dao = new ProductsDAO();
        List<ProductsDTO> list = dao.getList(null, null, null);
        Cookie[] arr = request.getCookies();
        String txt = "";
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cart")) {
                    txt += o.getValue();
                    o.setMaxAge(0);
                    response.addCookie(o);
                }
            }
        }
        CartsDTO cart = new CartsDTO(txt, list);
        String quantity_raw = request.getParameter("quantity");
        String id_raw = request.getParameter("id");
        String user_id_raw = request.getParameter("user_id");
        int id, quantity, user_id = 0;
        try {
            id = Integer.parseInt(id_raw);
            ProductsDTO p = dao.getProductByid(id);
            int quantityInStore = p.getQuantity();
            quantity = Integer.parseInt(quantity_raw);
            user_id = Integer.parseInt(user_id_raw);
            if (quantity == -1 && (cart.getQuantitybyId(id) <= 1)) {
                cart.removeItem(id);
            } else if(quantity == 0){
                cart.removeItem(id);
            }else {
                if (quantity == 1 && cart.getQuantitybyId(id) >= quantityInStore) {
                    quantity = 0;
                }
                double price = p.getNewPrice();
                ItemsDTO t = new ItemsDTO(p, quantity, price, user_id);
                cart.addItems(t);
            }
        } catch (NumberFormatException e) {
        }
        List<ItemsDTO> items = cart.getItems();
        txt = "";
        if (items.size() > 0) {
            txt = items.get(0).getUser_id() + ":"
                    + items.get(0).getProduct().getProduct_id() + "-"
                    + items.get(0).getQuantity();
            for (int i = 1; i < items.size(); i++) {
                txt += "," + items.get(0).getUser_id() + ":"
                        + items.get(0).getProduct().getProduct_id() + "-"
                        + items.get(0).getQuantity();
            }
        }
        
        Cookie cookie = new Cookie("cart", txt);
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);
        request.setAttribute("cart", cart);
        } catch (Exception e) {
        }
        request.getRequestDispatcher("cart.jsp").forward(request, response);
        
        
//        if(action.equals("saveinfoOder")){
//            String Cname
//        }
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
