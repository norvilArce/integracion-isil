package pe.isil.resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.isil.dto.ProductDto;
import pe.isil.service.ProductCommandService;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("api/products")
public class ProductResource {

    private final ProductCommandService commandService;

    public ProductResource(ProductCommandService commandService) {
        this.commandService = commandService;
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        productDto.setProductId((UUID.randomUUID()));
        ProductDto productDtoCreated = commandService.createProduct(productDto);
        log.info("productDtoCreated: {}", productDtoCreated);
        return new ResponseEntity<>(productDtoCreated, HttpStatus.CREATED);
    }

}
