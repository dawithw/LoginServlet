package controller;

import model.Database;
import model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.xml.crypto.Data;
import java.io.IOException;

@WebServlet({"/login",""})
public class Login extends HttpServlet {
    @Override
    public void init() {
        this.getServletContext().setAttribute("database",new Database());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = getUser(req);
        HttpSession session = req.getSession();

        // add cookie
        if("on".equals(req.getParameter("remember"))) {
            Cookie cookie = new Cookie("user",user.getUsername());
            cookie.setMaxAge(60*60*24*30);
            resp.addCookie(cookie);
        }
        // remove cookie if exists
        else {
            Cookie cookie = getCookie(user, req.getCookies());
            if (cookie != null) {
                cookie.setMaxAge(-1);       // delete immediately
                resp.addCookie(cookie);
            }
        }

        if(user != null ) {
            session.setAttribute("user",user);
            resp.sendRedirect("welcome.jsp");
        } else {
            session.setAttribute("login_error","The Username/Passowrd combination does not exist.");
            resp.sendRedirect("/login");
        }
    }

    private Cookie getCookie(User user, Cookie[] cookies) {
        if (user == null)
            return  null;

        for(Cookie c : cookies) {
            if(user.getUsername() == c.getValue()) {
                return c;
            }
        }
        return null;
    }

    private User getUser(HttpServletRequest req){
        String username = req.getParameter("username");
        String password = req.getParameter("passowrd");
        Database db = (Database)this.getServletContext().getAttribute("database");
        return db.getUser(username,password);
    }
}
