package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Daily;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.CatalogService;
import org.csu.mypetstore.service.DailyService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class ViewProductServlet extends HttpServlet {
    private String productId;

    private DailyService dailyService;
    private Daily daily;
    private Account account;

    private static final String VIEW_PRODUCT = "/WEB-INF/jsp/catalog/Product.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productId = req.getParameter("productId");
        dailyService = new DailyService();

        CatalogService catalogService = new CatalogService();
        Product product = catalogService.getProduct(productId);
        List<Item> itemList = catalogService.getItemListByProduct(productId);

        HttpSession session = req.getSession();
        session.setAttribute("product",product);
        session.setAttribute("itemList",itemList);

        account=(Account) session.getAttribute("account");
        if(account != null){
            daily = new Daily();
            daily.setUserid(account.getUsername());
            daily.setOperationtype("view Product "+productId);
            daily.setDate(new Date());

            dailyService.insertDaily(daily);
        }

        req.getRequestDispatcher(VIEW_PRODUCT).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
