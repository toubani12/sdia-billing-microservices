package ma.enset.sdia.inventory.repository;

import ma.enset.sdia.inventory.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "products", collectionResourceRel = "products")
public interface ProductRepository extends JpaRepository<Product, Long> {

    // exposed as GET /api/products/search/low-stock?threshold=...
    @RestResource(path = "low-stock")
    List<Product> findByStockLessThan(@Param("threshold") int threshold);
}
