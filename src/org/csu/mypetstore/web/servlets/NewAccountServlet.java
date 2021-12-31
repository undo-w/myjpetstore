package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.AccountService;
import org.csu.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewAccountServlet extends HttpServlet {
    private static final String SIGNON_FORM = "/WEB-INF/jsp/account/SignonForm.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";

    private AccountService accountService;
    private CatalogService catalogService;
    private List<Product> myList;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        accountService = new AccountService();
        catalogService = new CatalogService();
        myList = new ArrayList<>();
        HttpSession session = req.getSession();

        Account account = new Account();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repeatedPassword = req.getParameter("repeatedPassword");
        String firstName = req.getParameter("account.firstName");
        String phone = req.getParameter("account.phone");
        String lastName = req.getParameter("account.lastName");
        String email = req.getParameter("account.phone");
        String address1 = req.getParameter("account.address1");
        String address2 = req.getParameter("account.address2");
        String city = req.getParameter("account.city");
        String state = req.getParameter("account.state");
        String zip = req.getParameter("account.zip");
        String country = req.getParameter("account.country");
        String language = req.getParameter("account.languagePreference");
        String favouriteCategory = req.getParameter("account.favouriteCategoryId");

        boolean isMyList = false;
        boolean isBanner = false;
        if(req.getParameter("account.listOption")!=null){
            isMyList = true;
        }
        if(req.getParameter("account.bannerOption")!=null){
            isBanner = true;
        }



        if(!password.equals(repeatedPassword))
        {
            String msg = "两次密码输入不一致！";
            session.setAttribute("msg",msg);
            req.getRequestDispatcher(ERROR).forward(req,resp);
        }
        else {
            account.setUsername(username);
            account.setPassword(password);
            account.setFirstName(firstName);
            account.setLastName(lastName);
            account.setEmail(email);
            account.setPhone(phone);
            account.setAddress1(address1);
            account.setAddress2(address2);
            account.setCity(city);
            account.setState(state);
            account.setZip(zip);
            account.setCountry(country);
            account.setLanguagePreference(language);
            account.setFavouriteCategoryId(favouriteCategory);
            account.setListOption(isMyList);
            account.setBannerOption(isBanner);

            if(account.isBannerOption()){
                account.setBannerName(account.getFavouriteCategoryId());
            }
            //问老师
            boolean authenticated = true;
            boolean isAuthenticated = (authenticated && account != null && account.getUsername() != null);
            account.setStatus(isAuthenticated?"1":"0");

            accountService.insertAccount(account);
            myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());

            //session.setAttribute("account",account);
            req.getRequestDispatcher(SIGNON_FORM).forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
