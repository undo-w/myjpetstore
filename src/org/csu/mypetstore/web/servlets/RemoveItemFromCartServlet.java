package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.Daily;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.service.DailyService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class RemoveItemFromCartServlet extends HttpServlet {
    private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";

    private Cart cart ;
    private String workingItemId;
    private DailyService dailyService;

    private Account account;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        workingItemId = req.getParameter("workingItemId");

        dailyService = new DailyService();
        HttpSession session = req.getSession();
        cart = (Cart)session.getAttribute("cart");

        Item item = cart.removeItemById(workingItemId);

        Daily daily ;
        account=(Account) session.getAttribute("account");
        if(account != null){
            daily = new Daily();
            daily.setUserid(account.getUsername());
            daily.setOperationtype("remove "+ workingItemId + " from the cart");
            daily.setDate(new Date());

            dailyService.insertDaily(daily);
        }

        // 防止删除后再次刷新页面
        if(item == null){
            session.setAttribute("msg","Attempted to delete a null item");
            req.getRequestDispatcher(ERROR).forward(req,resp);
        }
        else {
            req.getRequestDispatcher(VIEW_CART).forward(req,resp);
        }
    }
}
