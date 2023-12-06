package com.zemlar.discountService.api;

import com.zemlar.discountService.api.dto.ProductDto;
import com.zemlar.discountService.mapper.ProductMapper;
import com.zemlar.discountService.service.DiscountService;
import com.zemlar.discountService.service.ProductService;
import com.zemlar.discountService.service.domain.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    private final ProductService productService;

    private final ProductMapper productMapper;

    private final DiscountService discountService;

    public ProductController(ProductService productService, ProductMapper productMapper, DiscountService discountService) {
        this.productService = productService;
        this.productMapper = productMapper;
        this.discountService = discountService;

    }

    @GetMapping("/products")
    public List<ProductDto> getProducts() {
        return productService.getProducts()
                .stream().map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/products/{productId}/discount")
    public ProductDto getProductPrices(@PathVariable("productId") UUID productId,
                                       @RequestParam(value = "amount", defaultValue = "1") int amount) {

        Product product = productService.getProduct(productId).orElseThrow();
        return productMapper.toDto(discountService.calculateDiscountForProduct(product, amount));
    }

}
