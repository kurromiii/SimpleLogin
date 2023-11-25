package com.mftplus.simplelogin.controller.servlet;

import com.mftplus.simplelogin.controller.exception.AccessDeniedException;
import com.mftplus.simplelogin.model.entity.User;
import com.mftplus.simplelogin.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        try {
            if (userName != null && passWord != null){
                User user = User.builder().userName(userName).passWord(passWord).build();
                UserService.getUserService().login(user);
                response.sendRedirect("home.html");
                System.out.printf("%s [User logged In] %s", LocalDateTime.now(), userName);
            }else {
                throw new AccessDeniedException("Invalid username/password");
            }
        } catch (Exception e) {
            System.out.printf("%s [LOGIN-ERROR] %s", LocalDateTime.now(),userName);
            response.sendRedirect("error.html");
        } catch (AccessDeniedException e) {
            throw new RuntimeException(e);
        }
    }
}
