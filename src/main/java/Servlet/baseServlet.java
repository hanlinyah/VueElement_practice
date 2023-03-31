package Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class baseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url=req.getRequestURI();
        int methodStarIndex=url.lastIndexOf("/");
        String methodName=url.substring(methodStarIndex+1);

        Class<? extends baseServlet> cls=this.getClass();
        try {
            Method servletMethod = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            servletMethod.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
