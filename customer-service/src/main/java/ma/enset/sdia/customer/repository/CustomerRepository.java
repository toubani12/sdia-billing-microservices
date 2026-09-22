package ma.enset.sdia.customer.repository;

import ma.enset.sdia.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "customers", collectionResourceRel = "customers")
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // exposed as GET /api/customers/search/by-name?keyword=...
    @RestResource(path = "by-name")
    List<Customer> findByFullNameContainingIgnoreCase(@Param("keyword") String keyword);
}
