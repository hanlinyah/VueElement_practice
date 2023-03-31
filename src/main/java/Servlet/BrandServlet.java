package Servlet;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.Brand;
import pojo.PageBean;
import pojo.Pages;
import service.BrandService;
import service.impl.BrandServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/Brand/*")
public class BrandServlet extends baseServlet {
    private final BrandService brandService =new BrandServiceImpl();
    private final ObjectMapper objectMapper=new ObjectMapper();
    public void DeleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader bufferedReader=request.getReader();
        String jsonString= bufferedReader.readLine();

        int id  = objectMapper.readValue(jsonString,int.class);
        brandService.DeleteById(id);

        response.getWriter().write("success");
    }

    public void DeleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader bufferedReader=request.getReader();
        String jsonString= bufferedReader.readLine();

        int[] ids  = objectMapper.readValue(jsonString,int[].class);
        brandService.DeleteByIds(ids);

        response.getWriter().write("success");
    }

    public void Insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader bufferedReader=request.getReader();
        String jsonString= bufferedReader.readLine();

        Brand brand=objectMapper.readValue(jsonString,Brand.class);
        brandService.Insert(brand);

        response.getWriter().write("success");
    }

    public void selectById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader bufferedReader=request.getReader();
        String jsonString= bufferedReader.readLine();

        int id  = objectMapper.readValue(jsonString,int.class);
        Brand brand= brandService.selectById(id);

        String brandtoJSON=objectMapper.writeValueAsString(brand);
        response.setContentType("text/json;charset-utf-8");
        response.getWriter().write(brandtoJSON);
    }

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Brand> brands= brandService.selectAll();

        String brandstoJSON=objectMapper.writeValueAsString(brands);
        response.setContentType("text/json;charset-utf-8");
        response.getWriter().write(brandstoJSON);
    }

    public void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader bufferedReader=request.getReader();
        String jsonString= bufferedReader.readLine();

        Brand brand=objectMapper.readValue(jsonString,Brand.class);
        brandService.Update(brand);

        response.getWriter().write("success");
    }

    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader bufferedReader=request.getReader();
        String jsonString= bufferedReader.readLine();

        Pages pages=objectMapper.readValue(jsonString, Pages.class);
        PageBean<Brand> pageBean= brandService.selectByPage(pages);

        String pageBeantoJSON=objectMapper.writeValueAsString(pageBean);
        response.setContentType("text/json;charset-utf-8");
        response.getWriter().write(pageBeantoJSON);
    }

    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader bufferedReader=request.getReader();
        String jsonString= bufferedReader.readLine();

        Pages<Brand> pages=objectMapper.readValue(jsonString, new TypeReference<Pages<Brand>>(){});
        PageBean<Brand> pageBean= brandService.selectByPageAndCondition(pages);

        String pageBeantoJSON=objectMapper.writeValueAsString(pageBean);
        response.setContentType("text/json;charset-utf-8");
        response.getWriter().write(pageBeantoJSON);
    }


}
