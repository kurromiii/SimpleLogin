package com.mftplus.simplelogin.controller.servlet;

import com.mftplus.simplelogin.model.entity.User;
import com.mftplus.simplelogin.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        boolean remember = (request.getParameter("remember") != null) ? true : false;

        if (remember) {
            Cookie uCookie = new Cookie("userName", userName);
            Cookie pCookie = new Cookie("passWord", passWord);
            response.addCookie(uCookie);
            response.addCookie(pCookie);
        }

        try {
            User user = User.builder().userName(userName).passWord(passWord).build();
            if (UserService.getUserService().login(user) != null) {
                request.getSession().setAttribute("username", user.getUserName());
                request.getRequestDispatcher("/html/home.html").forward(request,response);
            }else{
                throw  new AccessDeniedException("Cant Login");
            }
        } catch (Exception e) {
            request.getRequestDispatcher("/html/error.html").forward(request,response);
        }

    }
}
