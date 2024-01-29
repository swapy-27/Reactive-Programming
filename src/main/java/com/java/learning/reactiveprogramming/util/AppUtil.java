package com.java.learning.reactiveprogramming.util;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.java.learning.reactiveprogramming.dao.Product;
import com.java.learning.reactiveprogramming.dto.ProductDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AppUtil {

    public static Product dtoToEntity(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return product;
    }

    public  static  ProductDto entityToDto(Product product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product,productDto );
        return productDto;
    }


}
