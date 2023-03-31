package service;

import pojo.Brand;
import pojo.PageBean;
import pojo.Pages;

import java.util.List;

public interface BrandService {

    List<Brand> selectAll();

    void Insert(Brand brand);

    void Update(Brand brand);

    void DeleteById(int id);

    void DeleteByIds(int[] ids);

    Brand  selectById(int id);

    PageBean<Brand> selectByPage(Pages pages);

    PageBean<Brand> selectByPageAndCondition(Pages<Brand> pages);


}
