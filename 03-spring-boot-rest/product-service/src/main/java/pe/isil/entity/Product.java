package pe.isil.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import java.util.UUID;

@ToString
@Data
@Entity
public class Product {

    @Id
    private UUID id;
    private String sku;
    private String name;
    private Double price;

    @Version
    private int version;
}
