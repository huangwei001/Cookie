package com.test.hw;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * 验证Cookie
 * Created by huangwei on 2017/6/27.
 */
public class TestCookie1 extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("lastAccessTime")){
                    Long lastAccessTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastAccessTime);
                    printWriter.write(String.valueOf(date));
                }
            }

        }else {
            printWriter.write("第一次登陆");
        }

        Cookie cookie = new Cookie("lastAccessTime",System.currentTimeMillis() +"");
        response.addCookie(cookie);
    }

}
