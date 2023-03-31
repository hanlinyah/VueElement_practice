package Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/User/*")
public class UserServlet extends baseServlet{
    private final UserService userService =new UserServiceImpl();

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("登入");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        User user=  userService.login(username,password);

        resp.setContentType("text/html;charset=utf-8");

        PrintWriter writer=resp.getWriter();

        if(user != null){
            String rememberme=req.getParameter("rememberme");
            if("1".equals(rememberme)){
                int maxage=60*60*24*7;
                Cookie cookie_username=new Cookie("username",username);
                cookie_username.setMaxAge(maxage);
                resp.addCookie(cookie_username);

                Cookie cookie_password=new Cookie("password",password);
                cookie_password.setMaxAge(maxage);
                resp.addCookie(cookie_password);

            }
            HttpSession httpsession=req.getSession();
            httpsession.setAttribute("user",user);
            resp.sendRedirect("../assets/Brand/Brand_Element.html");

        }else {
            req.setAttribute("loginmessage","用戶名稱或密碼錯誤");
            req.getRequestDispatcher("../assets/User/login.jsp").forward(req,resp);
        }
    }
    public void loginState(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpsession=req.getSession();
        User user= (User) httpsession.getAttribute("user");
        String username=user.getUsername();
        resp.setContentType("text/json;charset-utf-8");
        resp.getWriter().write(username);
    }
    public void registerCheckName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        boolean registerstate=  userService.registerCheckName(username);
        if(!registerstate){
            resp.getWriter().write("用戶名稱已存在");
        }else {
            resp.getWriter().write("");
        }
    }
    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputCode=req.getParameter("verifyCode");
        String verifyCode= req.getSession().getAttribute("verifyCode").toString();

        if(verifyCode.equalsIgnoreCase(inputCode)){
            String username=req.getParameter("username");
            String password=req.getParameter("password");
            boolean registerstate=  userService.register(username,password);

            PrintWriter writer=resp.getWriter();
            if(registerstate){
                req.setAttribute("registermessage","註冊成功，請登入");
                req.getRequestDispatcher("../assets/User/login.jsp").forward(req,resp);
            }else{
                req.setAttribute("registermessage","用戶名稱已存在");
                req.getRequestDispatcher("../assets/User/login.jsp").forward(req,resp);
            };

        }else {
            req.setAttribute("velifymessage","驗證碼輸入錯誤");
            req.getRequestDispatcher("../assets/User/register.jsp").forward(req,resp);
        }

    }
    public void verifyCode(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream os=resp.getOutputStream();
        String verifycode=util.verifyCode.outputVerifyImage(100,50,os,4);
        os.close();
        HttpSession httpsession=req.getSession();
        httpsession.setAttribute("verifyCode",verifycode);
    }
}
