package service.impl;
import pojo.Brand;
import pojo.PageBean;
import pojo.Pages;
import service.BrandService;
import util.BrandMapSession;
import java.util.List;

public class BrandServiceImpl implements BrandService {

    @Override
    public List<Brand> selectAll(){
        BrandMapSession brandMapSession= new BrandMapSession();
        List<Brand> brands=brandMapSession.getMapper().selectAll();
        brandMapSession.closeSession();
        return brands;
    }

    @Override
    public void Insert(Brand brand){
        BrandMapSession brandMapSession= new BrandMapSession();
        brandMapSession.getMapper().Insert(brand);
        brandMapSession.closeSession();
    }

    @Override
    public void Update(Brand brand){
        BrandMapSession brandMapSession= new BrandMapSession();
        brandMapSession.getMapper().Update(brand);
        brandMapSession.closeSession();
    }

    @Override
    public void DeleteById(int id){
        BrandMapSession brandMapSession= new BrandMapSession();
        brandMapSession.getMapper().DeleteById(id);
        brandMapSession.closeSession();
    }

    public void DeleteByIds(int[] ids){
        BrandMapSession brandMapSession= new BrandMapSession();
        brandMapSession.getMapper().DeleteByIds(ids);
        brandMapSession.closeSession();
    }

    @Override
    public Brand  selectById(int id){
        BrandMapSession brandMapSession= new BrandMapSession();
        Brand brand=brandMapSession.getMapper().selectById(id);
        brandMapSession.closeSession();
        return brand;
    }

    @Override
    public PageBean<Brand> selectByPage(Pages pages){
        BrandMapSession brandMapSession= new BrandMapSession();
        int size=pages.getPagesize();
        int begin=(pages.getCurrentpage()-1)*size;
        int totalrows=brandMapSession.getMapper().selectTotalrows();
        List<Brand> brands=brandMapSession.getMapper().selectByPage(begin,size);
        PageBean<Brand> pageBeanBrands=new PageBean<>(totalrows,brands);
        brandMapSession.closeSession();
        return pageBeanBrands;
    };

    @Override
    public PageBean<Brand> selectByPageAndCondition(Pages<Brand> pages){
        BrandMapSession brandMapSession= new BrandMapSession();
        int size=pages.getPagesize();
        int begin=(pages.getCurrentpage()-1)*size;
        Brand brand=pages.getSearchdata();
        String brandName=brand.getBrandName();
        String companyName=brand.getCompanyName();
        if(brandName!=null && brandName.length()>0){brand.setBrandName("%"+brandName.trim()+"%");}
        if(companyName!=null && companyName.length()>0){brand.setCompanyName("%"+companyName.trim()+"%");}
        int totalrows=brandMapSession.getMapper().selectTotalrowsByCondition(brand);
        List<Brand> brands=brandMapSession.getMapper().selectByPageAndCondition(begin,size,brand);
        PageBean<Brand> pageBeanBrands=new PageBean<>(totalrows,brands);
        brandMapSession.closeSession();
        return pageBeanBrands;
    };
}
