package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Cart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ShipToConfirmOrderServlet extends HttpServlet {
    private static final String CONFIRM_ORDER = "/WEB-INF/jsp/order/ConfirmOrder.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       String shipToFirstName = req.getParameter("shipToFirstName");
       String shipToLastName = req.getParameter("shipToLastName");
       String shipAddress1 = req.getParameter("shipAddress1");
       String shipAddress2 = req.getParameter("shipAddress2");
       String shipCity = req.getParameter("shipCity");
       String shipState = req.getParameter("shipState");
       String shipZip = req.getParameter("shipZip");
       String shipCountry = req.getParameter("shipCountry");

        HttpSession session = req.getSession();
        session.setAttribute("shipToFirstName",shipToFirstName);
        session.setAttribute("shipToLastName",shipToLastName);
        session.setAttribute("shipAddress1",shipAddress1);
        session.setAttribute("shipAddress2",shipAddress2);
        session.setAttribute("shipCity",shipCity);
        session.setAttribute("shipState",shipState);
        session.setAttribute("shipZip",shipZip);
        session.setAttribute("shipCountry",shipCountry);

        req.getRequestDispatcher(CONFIRM_ORDER).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
