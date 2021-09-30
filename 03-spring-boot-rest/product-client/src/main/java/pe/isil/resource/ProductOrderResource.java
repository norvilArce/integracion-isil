package pe.isil.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.isil.dto.ProductOrderDto;
import pe.isil.service.ProductOrderCommandService;

@RestController
@RequestMapping("/api/product-order")
public class ProductOrderResource {
    private final ProductOrderCommandService commandService;

    public ProductOrderResource(ProductOrderCommandService commandService) {
        this.commandService = commandService;
    }

    @PostMapping("/create")
    public ResponseEntity<ProductOrderDto> createProductOrder(@RequestBody ProductOrderDto productOrderDto){
        return new ResponseEntity<>(commandService.createProductOrder(productOrderDto), HttpStatus.CREATED);
    }
}
