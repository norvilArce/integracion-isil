package pe.isil.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pe.isil.dto.ProductDto;
import pe.isil.dto.ProductOrderDto;

@Slf4j
@Service
public class ProductOrderCommandService {

    private static final String PRODUCT_ENDPOINT = "http://localhost:9080/api/products";
    private final RestTemplate restTemplate;

    public ProductOrderCommandService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ProductOrderDto createProductOrder(ProductOrderDto productOrderDto) {
        ProductDto productDto = extractProduct(productOrderDto);
        HttpEntity<ProductDto> request = new HttpEntity<>(productDto);
        ProductDto productDtoResponse = restTemplate.postForObject(PRODUCT_ENDPOINT + "/create", request, ProductDto.class);
        assert productDtoResponse != null;
        return addProductDto(productDtoResponse);
    }

    private ProductOrderDto addProductDto(ProductDto response) {
        ProductOrderDto productOrderDto = new ProductOrderDto();
        productOrderDto.setProductId(response.getProductId());
        productOrderDto.setSku(response.getSku());
        productOrderDto.setName(response.getName());
        productOrderDto.setPrice(response.getPrice());
        return productOrderDto;
    }

    private ProductDto extractProduct(ProductOrderDto productOrderDto) {
        ProductDto productDto = new ProductDto();
        productDto.setSku(productOrderDto.getSku());
        productDto.setName(productOrderDto.getName());
        productDto.setPrice(productOrderDto.getPrice());
        return productDto;
    }
}
