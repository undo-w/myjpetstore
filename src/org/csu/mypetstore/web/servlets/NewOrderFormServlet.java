package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Cart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class NewOrderFormServlet extends HttpServlet {

    private static final String NEW_ORDER_FORM = "/WEB-INF/jsp/order/NewOrderForm.jsp";
    private static final String SIGNON_FORM = "/WEB-INF/jsp/account/SignonForm.jsp";

    private Account account;
    //Cart cart ;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        account =(Account) session.getAttribute("account");
        if(account==null){
            req.getRequestDispatcher(SIGNON_FORM).forward(req,resp);
        }
        else {
            req.getRequestDispatcher(NEW_ORDER_FORM).forward(req,resp);
        }

    }
}
