package ma.enset.sdia.billing.repository;

import ma.enset.sdia.billing.domain.Bill;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill, Long> {

    @Override
    @EntityGraph(attributePaths = "items")
    List<Bill> findAll();

    @EntityGraph(attributePaths = "items")
    Optional<Bill> findWithItemsById(Long id);

    @EntityGraph(attributePaths = "items")
    List<Bill> findByCustomerId(Long customerId);
}
