package com.zemlar.discountService.data.repository;

import com.zemlar.discountService.data.entity.ProductEntity;
import com.zemlar.discountService.mapper.ProductMapper;
import com.zemlar.discountService.service.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.naming.Name;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProductJdbcRepository implements ProductRepository {

    private static final Logger logger = LoggerFactory.getLogger(ProductJdbcRepository.class);

    public static final String GET_ALL_PRODUCTS = "SELECT * from PRODUCT";

    public static final String GET_PRODUCT_BY_UUID = "SELECT * from PRODUCT where uuid =:productUUID";

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final ProductMapper mapper;

    public ProductJdbcRepository(JdbcTemplate jdbcTemplate, ProductMapper mapper) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        this.mapper = mapper;
    }


    @Override
    public List<Product> getProducts() {

        return jdbcTemplate.query(GET_ALL_PRODUCTS, (rs, rowId) -> mapToEntity(rs))
                .stream()
                .filter(Optional::isPresent)
                .flatMap(Optional::stream)
                .map(mapper::toDomainObject)
                .toList();
    }

    @Override
    public Optional<Product> getProductByUUID(UUID uuid) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("productUUID", uuid);
        return jdbcTemplate.queryForObject(
                        GET_PRODUCT_BY_UUID, namedParameters, (rs, i) -> mapToEntity(rs))
                .map(mapper::toDomainObject);
    }

    private Optional<ProductEntity> mapToEntity(ResultSet resultSet) {
        try {
            return Optional.of(
                    new ProductEntity(
                            resultSet.getLong("id"),
                            resultSet.getObject("uuid", UUID.class),
                            resultSet.getString("name"),
                            resultSet.getBigDecimal("base_price")
                    )
            );
        } catch (SQLException e) {
            logger.warn("Problem during mapping product class", e);
            return Optional.empty();
        }
    }


}
