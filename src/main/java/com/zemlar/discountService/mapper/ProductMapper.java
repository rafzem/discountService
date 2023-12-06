package com.zemlar.discountService.mapper;


import com.zemlar.discountService.api.dto.ProductDto;
import com.zemlar.discountService.data.entity.ProductEntity;
import com.zemlar.discountService.service.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMapper {


    Product toDomainObject(ProductEntity entity);

    @Mappings({
            @Mapping(target = "price",source = "basePrice")
    })
    ProductDto toDto(Product product);
}
