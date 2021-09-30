package pe.isil.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.isil.dto.ProductDto;
import pe.isil.entity.Product;
import pe.isil.repository.ProductRepository;

@Slf4j
@Service
public class ProductCommandService {

    private final ProductRepository productRepository;

    public ProductCommandService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDto createProduct(ProductDto dto) {
        Product product = dtoToEntity(dto);
        log.info("product: {}", product);
        Product productCreated = productRepository.save(product);
        log.info("productCreated: {}", productCreated);
        //evento
        return entityToDto(productCreated);
    }

    private ProductDto entityToDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getId());
        productDto.setSku(product.getSku());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        return productDto;
    }

    private Product dtoToEntity(ProductDto dto) {
        Product product = new Product();
        product.setId(dto.getProductId());
        product.setSku(dto.getSku());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        return product;
    }

}
