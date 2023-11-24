package com.mftplus.simplelogin.controller.servlet;

import com.mftplus.simplelogin.model.entity.User;
import com.mftplus.simplelogin.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = "/user.do")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String name = request.getParameter("name");
       String family = request.getParameter("family");
       String userName = request.getParameter("userName");
       String passWord = request.getParameter("passWord");
       try {
           if (name != null && family != null && userName != null && passWord != null){
               User user = User.builder().name(name)
                       .family(family).userName(userName)
                       .passWord(passWord)
                       .build();
               UserService.getUserService().save(user);
               System.out.printf("%s [User Save] %s", LocalDateTime.now(), userName);
           }
       } catch (Exception e) {
           System.out.printf("%s [User Save ERROR] %s", LocalDateTime.now(), userName);
           System.out.println(e.getMessage());
       }
       response.sendRedirect("");
    }
}
