package main.java.web.servlet;


import dao.impl.*;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cabinet")
public class UserServlet extends HttpServlet {
    private UserDaoImpl userDaoImpl = new UserDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = String.valueOf(req.getSession().getAttribute("login"));
        String password = String.valueOf(req.getSession().getAttribute("password"));
        User user = userDaoImpl.getByLoginAndPassword(login, password);

        req.setAttribute("user", user);
        req.getRequestDispatcher("orderDetails.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String role = String.valueOf(req.getSession().getAttribute("role"));
        String login = String.valueOf(req.getSession().getAttribute("login"));
        String password = String.valueOf(req.getSession().getAttribute("password"));

        if (role.equals("USER")) {
            User user = userDaoImpl.getByLoginAndPassword(login, password);
            req.setAttribute("user", user);
            req.getRequestDispatcher("user.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/login");
        }
    }

}
