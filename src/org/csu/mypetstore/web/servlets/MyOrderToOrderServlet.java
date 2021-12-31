package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Daily;
import org.csu.mypetstore.domain.Order;
import org.csu.mypetstore.service.DailyService;
import org.csu.mypetstore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class MyOrderToOrderServlet extends HttpServlet {
    private static final String VIEW_ORDER = "/WEB-INF/jsp/order/ViewOrder.jsp";
    private OrderService orderService;
    private Order order;

    private Daily daily;

    private DailyService dailyService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String oid = req.getParameter("orderId");
        int orderId = Integer.parseInt(oid);

        orderService = new OrderService();
        dailyService = new DailyService();
        Account account = (Account) session.getAttribute("account");
        order = orderService.getOrder(orderId);

        daily = new Daily();
        daily.setUserid(account.getUsername());
        daily.setOperationtype("view order "+ order.getOrderId());
        daily.setDate(new Date());

        dailyService.insertDaily(daily);

        session.setAttribute("order",order);
        req.getRequestDispatcher(VIEW_ORDER).forward(req,resp);
    }
}
