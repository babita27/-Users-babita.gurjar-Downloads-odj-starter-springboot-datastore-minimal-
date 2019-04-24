package onedj.gcp.datastore.entities;

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Component
@Repository
public interface ProductRepository extends DatastoreRepository<ProductEntity, Long> {

    List<ProductEntity> findByName(String name);
    List<ProductEntity> findByEan(String ean);
    List<ProductEntity> findBySku(String sku);

    List<ProductEntity> findByPriceLessThan(float price);

    List<ProductEntity> findByPriceGreaterThan(float price);
}
