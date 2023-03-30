package com.magnusinfinity.magnusinfinitybackend.controller;

import com.magnusinfinity.magnusinfinitybackend.dao.entity.ProductInfo;
import com.magnusinfinity.magnusinfinitybackend.dao.repository.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @PostMapping("/add")
    public String add(@RequestBody ProductInfo productInfo){
        ProductInfo productInfo1 = productInfoRepository.save(productInfo);
        return productInfo1.getId();
    }

    @GetMapping("/getProductInfo")
    public ProductInfo get(@RequestParam("id") String id){
        return productInfoRepository.findById(id).get();
    }

}
