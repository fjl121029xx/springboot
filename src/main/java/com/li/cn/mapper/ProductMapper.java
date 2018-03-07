package com.li.cn.mapper;


import com.li.cn.bean.ProductEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Insert("insert into products(pname,type,price) values (#{pname},#{type},#{price})")
    Integer addProduct(ProductEntity productEntity);

    @Select("select * from products where id = #{arg1}")
    ProductEntity getProductById(Integer id);

    @Update("update products set pname = #{pname},type = #{type},price = #{price} where id = #{id} ")
    Integer updateProduct(ProductEntity productEntity);

    @Delete("delete from products where id = #{arg1}")
    Integer deleteProductById(Integer id);

    @Select("select * from products")
    List<ProductEntity> getProducts();
}
