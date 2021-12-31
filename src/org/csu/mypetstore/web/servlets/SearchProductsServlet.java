package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class SearchProductsServlet extends HttpServlet {
    private static final String SEARCH_PRODUCTS = "/WEB-INF/jsp/catalog/SearchProducts.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";

    private String keyword;
    private List<Product> productList;

    CatalogService catalogService = new CatalogService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        keyword = req.getParameter("keyword");

        if (keyword == null || keyword.length() < 1) {
            session.setAttribute("msg","Please enter a keyword to search for, then press the search button.");
            req.getRequestDispatcher(ERROR).forward(req,resp);
        } else {
            productList = catalogService.searchProductList(keyword.toLowerCase());
            session.setAttribute("productList",productList);
            req.getRequestDispatcher(SEARCH_PRODUCTS).forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
