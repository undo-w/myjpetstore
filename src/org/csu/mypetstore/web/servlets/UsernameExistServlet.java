package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UsernameExistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        AccountService accountService = new AccountService();
        Account account = accountService.getAccount(username);

        // 设置响应的类型
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();

        if(account == null){
            // 用户不存在，可以使用该用户名
            out.print("Not Exist");
        }
        else{
            // 用户名已存在，无法使用该用户名
            out.print("Exist");
        }
        out.flush();
        out.close();
    }
}
