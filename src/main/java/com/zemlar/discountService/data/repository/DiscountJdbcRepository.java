package com.zemlar.discountService.data.repository;

import com.zemlar.discountService.data.entity.DiscountEntity;
import com.zemlar.discountService.mapper.DiscountMapper;
import com.zemlar.discountService.service.domain.Discount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class DiscountJdbcRepository implements DiscountRepository {

    private static final Logger logger = LoggerFactory.getLogger(DiscountJdbcRepository.class);

    public static final String GET_DISCOUNTS_BY_PRODUCT =
            """
                    SELECT d.* FROM DISCOUNT d
                    LEFT JOIN PRODUCT_DISCOUNT_GROUP_ASSOCIATION pdga on d.discount_group_id = pdga.discount_group_id
                    LEFT JOIN PRODUCT p on pdga.product_id = p.id\s
                    where p.uuid =:uuid\s
                         """;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final DiscountMapper discountMapper;

    public DiscountJdbcRepository(JdbcTemplate jdbcTemplate, DiscountMapper discountMapper) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        this.discountMapper = discountMapper;
    }

    @Override
    public List<Discount> getDiscountsForProduct(UUID productUUID) {

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("uuid", productUUID);
        return jdbcTemplate.query(
                        GET_DISCOUNTS_BY_PRODUCT, namedParameters, (rs, i) -> mapToEntity(rs))
                .stream()
                .filter(Optional::isPresent)
                .flatMap(Optional::stream)
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    private Discount mapToDomain(DiscountEntity discountEntity) {

        if (discountEntity.type().equals(DiscountEntity.DiscountType.COUNT_BASED)) {
            return discountMapper.mapToAmountBasedDiscount(discountEntity);
        } else {
            return discountMapper.mapToPercentageDiscount(discountEntity);
        }
    }

    private Optional<DiscountEntity> mapToEntity(ResultSet rs) {

        try {

            return Optional.of(
                    new DiscountEntity(
                            rs.getLong("id"),
                            rs.getLong("discount_group_id"),
                            DiscountEntity.DiscountType.getByType(rs.getString("type")),
                            rs.getBigDecimal("discount_value"),
                            rs.getInt("min_product_amount"),
                            rs.getBigDecimal("base_discount"),
                            rs.getBigDecimal("max_discount"),
                            rs.getBigDecimal("discount_step")
                    )
            );

        } catch (SQLException e) {
            logger.warn("Problem during mapping product class", e);
            return Optional.empty();
        }
    }
}
