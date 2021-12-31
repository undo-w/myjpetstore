package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.Daily;
import org.csu.mypetstore.service.AccountService;
import org.csu.mypetstore.service.CatalogService;
import org.csu.mypetstore.service.DailyService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class SignOnServlet extends HttpServlet {
    private static final String CATALOG = "/WEB-INF/jsp/catalog/Main.jsp";
    private static final String SIGN_FAILED = "/WEB-INF/jsp/account/SignFailed.jsp";
    private static final String NEW_ORDER_FORM = "/WEB-INF/jsp/order/NewOrderForm.jsp";
    //private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";

    private Account account;
    Cart cart;
    AccountService accountService = new AccountService();
    CatalogService catalogService = new CatalogService();
    DailyService dailyService = new DailyService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkcodeFromUser = req.getParameter("verificationCode");
        String checkcode = (String) session.getAttribute("checkcode");

        cart = (Cart) session.getAttribute("cart");

        //Account acc = (Account) session.getAttribute("account");

        account = accountService.getAccount(username, password);

        if (account == null) {
            String msg = "Invalid username or password.  Signon failed.";
            session.setAttribute("msg",msg);
            req.getRequestDispatcher(SIGN_FAILED).forward(req,resp);
        }
        else if(!checkcode.equals(checkcodeFromUser)){
            String msg = "Wrong verificationCode. Signon failed.";
            session.setAttribute("msg",msg);
            req.getRequestDispatcher(SIGN_FAILED).forward(req,resp);
        }
        else {
            account.setPassword(null);

            Daily daily = new Daily();
            daily.setUserid(account.getUsername());
            daily.setOperationtype("Sign On");
            daily.setDate(new Date());

            dailyService.insertDaily(daily);

            session.setAttribute("account",account);
            req.getRequestDispatcher(CATALOG).forward(req,resp);
//            if(cart == null){
//                req.getRequestDispatcher(CATALOG).forward(req,resp);
//            }
//            else {
//                session.setAttribute("cart",cart);
//                req.getRequestDispatcher(NEW_ORDER_FORM).forward(req,resp);
//            }
            //myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());

        }
    }
}
