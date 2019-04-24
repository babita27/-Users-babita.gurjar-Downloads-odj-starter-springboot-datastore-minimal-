package onedj.gcp.datastore.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class ProductEntity {

    public ProductEntity(String name, Float price, String sku) {
        this.name = name;
        this.price = price;
        this.sku = sku;
    }

    @Id
    Long id;

    String name;

    String description;

    String ean;

    Float price;

    String sku;

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ean='" + ean + '\'' +
                ", price=" + price +
                ", sku='" + sku + '\'' +
                '}';
    }

//    public ProductEntity(String name, String description, String ean, Float price, String sku) {
//        System.out.println("Inside");
//        this.name = name;
//        this.description = description;
//        this.ean = ean;
//        this.price = price;
//        this.sku = sku;
//    }
}