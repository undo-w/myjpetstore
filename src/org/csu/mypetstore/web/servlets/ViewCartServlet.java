package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Cart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ViewCartServlet extends HttpServlet {
    private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private static final String SIGN_ON = "/WEB-INF/jsp/cart/SignonForm.jsp";
    private Cart cart;
    private Account account;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        cart = (Cart) session.getAttribute("cart");
        account = (Account) session.getAttribute("account");

        if(account==null){
            req.getRequestDispatcher(SIGN_ON).forward(req,resp);
            return;
        }
        if(cart == null){
            cart = new Cart();
            session.setAttribute("cart",cart);
        }
        else{

        }
        req.getRequestDispatcher(VIEW_CART).forward(req,resp);
    }
}
