import com.fasterxml.jackson.databind.ObjectMapper;
import mapper.BrandMapper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pojo.Brand;
import pojo.PageBean;
import pojo.Pages;
import service.BrandService;
import service.impl.BrandServiceImpl;
import util.BrandMapSession;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BrandTest {
    static BrandMapSession brandMapSession;
    static BrandMapper brandMapper;
    private final BrandService brandService =new BrandServiceImpl();

    private final ObjectMapper objectMapper=new ObjectMapper();
    @BeforeClass
    public static void getsession(){
        brandMapSession=new util.BrandMapSession();
        brandMapper =brandMapSession.getMapper();
    }
    @AfterClass
    public static void closeSession(){
        brandMapSession.closeSession();
    }
    @Test
    public void selectAll_test(){
        System.out.println("[測試]查詢所有：");
        List<Brand> brands=brandMapper.selectAll();
        System.out.println(brands);
    }

    @Test
    public void selectById_test(){
        Integer id= new Random().nextInt(3)+1;
        System.out.println("[測試]根據ID查詢(查詢ID="+id+")");
        Brand brand=brandMapper.selectById(id);
        System.out.println(brand);
    }

    @Test
    public void Insert_test(){
        System.out.println("[測試]插入數據");
        System.out.print("插入前數據資料：呼叫→→→\t");
        selectAll_test();
        Brand brand = new Brand(null,"BrandNameTEST","companyameTEST",99,"descriptionTEST",9);
        brandMapper.Insert(brand);
        System.out.println("插入數據為："+brand);

        System.out.print("插入後數據資料：呼叫→→→\t");
        selectAll_test();
    }


    @Test
    public void Delete_test(){
        System.out.println("[測試]刪除數據ID=4之資料");
        List<Brand> brands=new ArrayList<>();
        System.out.print("刪除前數據資料：呼叫→→→\t");
        selectAll_test();
        Integer id= 4;
        brandMapper.DeleteById(id);
        System.out.print("刪除後數據資料：呼叫→→→\t");
        selectAll_test();
    }
    @Test
    public void selectByPage() throws Exception{
        Brand brand=new Brand(null,"","","");
        Pages pages=new Pages(1,100,brand);
        PageBean<Brand> pageBean= brandService.selectByPage(pages);
        String pageBeantoJSON=objectMapper.writeValueAsString(pageBean);
        System.out.println(pageBeantoJSON);
    }

    @Test
    public void selectByPageAndCondition() throws Exception{
        Brand brand=new Brand();
        brand.setStatus(0);
        brand.setBrandName(" 球");
        Pages<Brand> pages=new Pages(1,100,brand);
        PageBean<Brand> pageBean= brandService.selectByPageAndCondition(pages);
        String pageBeantoJSON=objectMapper.writeValueAsString(pageBean);
        System.out.println(pageBeantoJSON);
    }


}
