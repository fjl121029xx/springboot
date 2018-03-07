package com.li.cn.controller;

import com.li.cn.bean.ProductEntity;
import com.li.cn.mapper.ProductMapper;
import com.li.cn.web.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * product rest 服务
 */
@RestController
public class ProductController {

    @Autowired
    private ProductMapper productMapper;

    @PostMapping("/soa/product/add")
    public Object add(ProductEntity product) {

        Integer res = productMapper.addProduct(product);
        if (res == null) {
            return new Response("500", "", null);
        } else {
            return new Response("200", "", res);
        }
    }

    @GetMapping("/soa/product/get/{id}")
    public Object get(@PathParam(value = "id") Integer id) {

        ProductEntity product = productMapper.getProductById(id);

        if (product == null) {
            return new Response("500", "", null);
        } else {
            return new Response("200", "", product);
        }
    }

    @GetMapping("/soa/product/delete/{id}")
    public Object delete(@PathParam(value = "id") Integer id) {

        Integer res = productMapper.deleteProductById(id);

        if (res == null) {
            return new Response("500", "", null);
        } else {
            return new Response("200", "", res);
        }
    }

    @PutMapping("/soa/product/update/{id}")
    public Object update(ProductEntity product) {

        Integer res = productMapper.updateProduct(product);

        if (res == null) {
            return new Response("500", "", null);
        } else {
            return new Response("200", "", res);
        }
    }
}
