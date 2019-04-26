package onedj.gcp.datastore;

import com.google.common.collect.Lists;
import onedj.gcp.datastore.entities.ProductEntity;
import onedj.gcp.datastore.entities.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@Controller
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @PostMapping(value = "/product", consumes = "application/json")
    public ResponseEntity<ProductEntity> addProduct(ProductEntity product) {
        logger.info("Adding product {}", product);

        ProductEntity savedEntity = productRepository.save(product);
        return new ResponseEntity<>(savedEntity, OK);
    }


    @GetMapping(value = "/products", produces = "application/json")
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        List<ProductEntity> foundProducts = Lists.newArrayList(productRepository.findAll());
        return new ResponseEntity<>(foundProducts, OK);
    }


    @GetMapping(value = "/product/ean/{ean}", produces = "application/json")
    public ResponseEntity<List<ProductEntity>> getProductByEAN(@PathVariable("ean") String ean) {
        logger.info("getProductByEAN {}", ean);

        List<ProductEntity> foundProducts = productRepository.findByEan(ean);
        if (foundProducts.isEmpty()) {
            return new ResponseEntity<>(NOT_FOUND);
        }

        return new ResponseEntity<>(foundProducts, OK);
    }
}
