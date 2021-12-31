package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Daily;
import org.csu.mypetstore.service.DailyService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewDailyLogServlet extends HttpServlet {

    private static final String  DAILY_LOG = "/WEB-INF/jsp/daily/DailyLog.jsp";
    private DailyService dailyService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        dailyService = new DailyService();

        Account account = (Account) session.getAttribute("account");
        List<Daily> dailyList = new ArrayList<>();

        dailyList = dailyService.getDailyListByUserId(account.getUsername());

        session.setAttribute("dailyList",dailyList);

        req.getRequestDispatcher(DAILY_LOG).forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
