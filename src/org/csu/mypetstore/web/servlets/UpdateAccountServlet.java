package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.service.AccountService;
import org.csu.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class UpdateAccountServlet extends HttpServlet {

    private static final String UPDATE_ACCOUNT="/WEB-INF/jsp/account/SignonForm.jsp";
    private Account account=null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountService accountService = new AccountService();
        HttpSession session = req.getSession();
        account = (Account) session.getAttribute("account");

        // String username = req.getParameter("username");
        String MyList =  req.getParameter("account.listOption") ;
        String Banner =  req.getParameter("account.bannerOption");

        boolean isMyList = false;
        boolean isBanner = false;

        if(MyList!=null){
            isMyList = true;
        }
        if(Banner!=null){
            isBanner = true;
        }

        String password = req.getParameter("account.password");
        if(password!=null){
            account.setPassword(req.getParameter("account.password"));
        }

        account.setFirstName(req.getParameter("account.firstName"));
        account.setLastName(req.getParameter("account.lastName"));
        account.setEmail(req.getParameter("account.email"));
        account.setPhone(req.getParameter("account.phone"));
        account.setAddress1(req.getParameter("account.address1"));
        account.setAddress2(req.getParameter("account.address2"));
        account.setCity(req.getParameter("account.city"));
        account.setState(req.getParameter("account.state"));
        account.setZip(req.getParameter("account.zip"));
        account.setCountry(req.getParameter("account.country"));
        account.setLanguagePreference(req.getParameter("account.languagePreference"));
        account.setFavouriteCategoryId(req.getParameter("account.favouriteCategoryId"));
        account.setListOption(isMyList);
        account.setBannerOption(isBanner);

        //问老师
        boolean authenticated = true;
        boolean isAuthenticated = (authenticated && account != null && account.getUsername() != null);
        account.setStatus(isAuthenticated?"1":"0");

        accountService.updateAccount(account);
//        myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());

        //session.setAttribute("account",account);
        req.getRequestDispatcher(UPDATE_ACCOUNT).forward(req,resp);
    }
}
