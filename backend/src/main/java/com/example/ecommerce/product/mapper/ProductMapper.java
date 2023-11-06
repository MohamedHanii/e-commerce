package com.example.ecommerce.product.mapper;

import com.example.ecommerce.authentication.model.DTO.RegisterRequestDTO;
import com.example.ecommerce.product.model.DTO.ProductDTO;
import com.example.ecommerce.product.model.entity.Product;
import com.example.ecommerce.user.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    @Mapping(source = "productId", target = "id")
    Product productDTOToProduct(ProductDTO productDTO);

    @Mapping(source = "id", target = "productId")
    ProductDTO productToProductDTO(Product product);

    @Mapping(target = "id", ignore = true)
    void updateProductFromDTO(ProductDTO productDTO, @MappingTarget Product product);

    @Mapping(source = "id", target = "productId")
    List<ProductDTO> productsToProductDTOs(List<Product> products);


}
