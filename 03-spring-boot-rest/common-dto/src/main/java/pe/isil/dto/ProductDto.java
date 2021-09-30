package pe.isil.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
public class ProductDto {
    private UUID productId;
    private String sku;
    private String name;
    private Double price;
}
