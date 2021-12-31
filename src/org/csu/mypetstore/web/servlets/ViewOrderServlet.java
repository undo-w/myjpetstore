package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Cart;
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
import java.text.SimpleDateFormat;
import java.util.Date;

public class ViewOrderServlet extends HttpServlet {

    private static final String VIEW_ORDER="/WEB-INF/jsp/order/ViewOrder.jsp";
    private OrderService orderService ;
    private Order order;
    private Account account;
    private Cart cart;
    private Daily daily;

    private DailyService dailyService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        orderService = new OrderService();
        dailyService = new DailyService();

        HttpSession session = req.getSession();
        account = (Account) session.getAttribute("account");
        cart = (Cart) session.getAttribute("cart");
        order = new Order();
        order.initOrder(account,cart);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmm");
        //order.setOrderId(Integer.parseInt(formatter.format(date)));
        orderService.insertOrder(order);

        daily = new Daily();
        daily.setUserid(account.getUsername());
        daily.setOperationtype("A new order has been created and its ID is "+ order.getOrderId());
        daily.setDate(new Date());

        dailyService.insertDaily(daily);

        session.setAttribute("order",order);
        //清空购物车
        cart = null;
        session.setAttribute("cart",cart);

        req.getRequestDispatcher(VIEW_ORDER).forward(req,resp);
    }
}
