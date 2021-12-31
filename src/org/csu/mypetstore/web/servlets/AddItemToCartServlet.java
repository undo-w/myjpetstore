package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.Daily;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.service.CatalogService;
import org.csu.mypetstore.service.DailyService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class AddItemToCartServlet extends HttpServlet {

    // 1、定义静态常量存储servlet跳往的页面路径
    private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";

    //2、定义处理请求的变量
    private Cart cart ;
    private String workingItemId;

    private Account account;
    private DailyService dailyService;

    //3、定义service对象处理业务逻辑
    CatalogService catalogService = new CatalogService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        workingItemId = req.getParameter("workingItemId");
        dailyService = new DailyService();

        HttpSession session = req.getSession();
        cart = (Cart) session.getAttribute("cart");

        if(cart == null){
            cart = new Cart();
        }

        if(!cart.containsItemId(workingItemId)){
            boolean inStock = catalogService.isItemInStock(workingItemId);
            Item item = catalogService.getItem(workingItemId);
            cart.addItem(item,inStock);
        }
        else {
            cart.incrementQuantityByItemId(workingItemId);
        }

        Daily daily ;
        account=(Account) session.getAttribute("account");
        if(account != null){
            daily = new Daily();
            daily.setUserid(account.getUsername());
            daily.setOperationtype("add "+ workingItemId + " to the cart");
            daily.setDate(new Date());

            dailyService.insertDaily(daily);
        }
        session.setAttribute("cart",cart);
        req.getRequestDispatcher(VIEW_CART).forward(req,resp);
    }
}
