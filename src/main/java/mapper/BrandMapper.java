package mapper;

import org.apache.ibatis.annotations.*;
import pojo.Brand;

import java.util.List;

public interface BrandMapper {
    @ResultMap("brandResultMap")
    @Select(value = "select * from tb_brand")
    List<Brand> selectAll();

    @ResultMap("brandResultMap")
    @Select(value = "select * from tb_brand where id=#{id}")
    Brand selectById(Integer id);

    @Insert(value = "insert into tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void Insert(Brand brand);

    @Delete("delete from tb_brand where id=#{id}")
    void DeleteById(Integer id);

    void DeleteByIds(int[] ids);


    @Update("update tb_brand set brand_name=#{brandName},company_name=#{companyName}," +
            "ordered=#{ordered},description=#{description},status=#{status} where id= #{id}")
    void Update(Brand brand);

    @Select("select count(*) from tb_brand")
    int selectTotalrows();

    @ResultMap("brandResultMap")
    @Select("select * from tb_brand limit #{begin},#{size}")
    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);

    @ResultMap("brandResultMap")
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("Brand")Brand brand);

    int selectTotalrowsByCondition(Brand brand);
}
