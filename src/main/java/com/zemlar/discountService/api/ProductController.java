package com.zemlar.discountService.api;

import com.zemlar.discountService.api.dto.ProductDto;
import com.zemlar.discountService.mapper.ProductMapper;
import com.zemlar.discountService.service.domain.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    private final ProductService productService;

    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping("/products")
    public List<ProductDto> getProducts() {
        return productService.getProducts()
                .stream().map(productMapper::toDto)
                .collect(Collectors.toList());
    }


    @GetMapping("/products/{productId}/price")
    public ProductDto getProductPrices(@PathVariable("productId") String productId,
                                       @RequestParam(value = "amount", defaultValue = "1") int amount) {

        return null;
    }

}
