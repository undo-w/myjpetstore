package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Order;
import org.csu.mypetstore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ViewListOrderServlet extends HttpServlet {
    private static final String VIEW_LIST_ORDER="/WEB-INF/jsp/order/ListOrders.jsp";
    private static final String SIGNON_FORM ="/WEB-INF/jsp/account/SignonForm.jsp";
    private List<Order> orderList;
    private Account account;

    private OrderService orderService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        account = (Account) session.getAttribute("account");
        orderService = new OrderService();
        //orderList = (List<Order>) session.getAttribute("orderList");
        if(account == null){
            req.getRequestDispatcher(SIGNON_FORM).forward(req,resp);
        }
        else {
            orderList = orderService.getOrdersByUsername(account.getUsername());
            session.setAttribute("orderList",orderList);
            req.getRequestDispatcher(VIEW_LIST_ORDER).forward(req,resp);
        }
        //AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");

    }
}
