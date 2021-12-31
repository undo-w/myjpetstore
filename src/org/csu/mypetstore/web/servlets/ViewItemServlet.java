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

public class ViewItemServlet extends HttpServlet {
    private String itemId;
    private Account account;
    private DailyService dailyService;

    private static final String VIEW_ITEM ="/WEB-INF/jsp/catalog/Item.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        itemId = req.getParameter("itemId");

        CatalogService service = new CatalogService();
        dailyService = new DailyService();
        Item item = service.getItem(itemId);

        HttpSession session = req.getSession();
        session.setAttribute("item",item);

        Daily daily = new Daily();
        account=(Account) session.getAttribute("account");
        if(account != null){
            daily = new Daily();
            daily.setUserid(account.getUsername());
            daily.setOperationtype("view Item "+itemId);
            daily.setDate(new Date());

            dailyService.insertDaily(daily);
        }

        req.getRequestDispatcher(VIEW_ITEM).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
