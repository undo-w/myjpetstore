package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.service.DailyService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ConfirmOrderServlet extends HttpServlet {

    private static final String CONFIRM_ORDER="/WEB-INF/jsp/order/ConfirmOrder.jsp";
    private static final String SHIPPING_FORM = "/WEB-INF/jsp/order/ShippingForm.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String shippingAddressRequire = req.getParameter("shippingAddressRequired");
        boolean isShipDifferent;

        if(shippingAddressRequire==null){
            isShipDifferent = false;
        }
        else {
            isShipDifferent = true;
        }
        if(!isShipDifferent){
            req.getRequestDispatcher(CONFIRM_ORDER).forward(req,resp);
        }
        else {
            req.getRequestDispatcher(SHIPPING_FORM).forward(req,resp);
        }
    }
}
