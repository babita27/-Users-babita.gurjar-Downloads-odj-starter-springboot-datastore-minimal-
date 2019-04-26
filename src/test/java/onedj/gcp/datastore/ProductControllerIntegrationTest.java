package onedj.gcp.datastore;

import onedj.gcp.datastore.entities.ProductEntity;
import onedj.gcp.datastore.entities.ProductRepository;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
public class ProductControllerIntegrationTest {
    private static final Logger logger = LoggerFactory.getLogger(ProductControllerIntegrationTest.class);

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void insertAndListAllProducts() {
        // given
        final String ean = "4711_Original ☁️ cloudy soft ice cream";

        // create a temporary product that is immediately deleted
        ProductEntity ice = ProductEntity.builder().name("🍦").price(3.99f).description("❄️").ean(ean).build();
        productRepository.save(ice);

        List<ProductEntity> allProducts = Lists.newArrayList(productRepository.findAll());
        List<ProductEntity> productsByEan = productRepository.findByEan(ean);

        logger.info("Found entities: {}", allProducts);

        // then
        assertTrue(allProducts.stream().anyMatch(p -> p.getName().equals("🍦") && p.getEan().equals(ean)));
        assertTrue(!CollectionUtils.isEmpty(productsByEan) && productsByEan.get(0).getEan().equals(ean));

        // clean up
        productRepository.delete(ice);
    }

}
