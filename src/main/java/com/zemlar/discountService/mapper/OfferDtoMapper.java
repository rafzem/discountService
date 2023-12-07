package com.zemlar.discountService.mapper;

import com.zemlar.discountService.api.dto.OfferDto;
import com.zemlar.discountService.service.domain.Offer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface OfferDtoMapper {


    @Mappings({
            @Mapping(target = "uuid", source = "offer.product.uuid"),
            @Mapping(target = "name", source = "offer.product.name"),
            @Mapping(target = "basePrice", source = "offer.product.basePrice"),
    })
    OfferDto toDto(Offer offer);

}
