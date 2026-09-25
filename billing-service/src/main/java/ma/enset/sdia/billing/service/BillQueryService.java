package ma.enset.sdia.billing.service;

import ma.enset.sdia.billing.client.CustomerClient;
import ma.enset.sdia.billing.client.ProductClient;
import ma.enset.sdia.billing.domain.Bill;
import ma.enset.sdia.billing.repository.BillRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BillQueryService {

    private final BillRepository bills;
    private final CustomerClient customerClient;
    private final ProductClient productClient;

    public BillQueryService(BillRepository bills, CustomerClient customerClient, ProductClient productClient) {
        this.bills = bills;
        this.customerClient = customerClient;
        this.productClient = productClient;
    }

    public List<Bill> findAll() {
        return bills.findAll();
    }

    public Bill findDetailed(Long id) {
        Bill bill = bills.findWithItemsById(id).orElseThrow(() -> new BillNotFoundException(id));
        return enrich(bill);
    }

    public List<Bill> findDetailedByCustomer(Long customerId) {
        return bills.findByCustomerId(customerId).stream().map(this::enrich).toList();
    }

    // fills the @Transient fields with data owned by the other services
    private Bill enrich(Bill bill) {
        bill.setCustomer(customerClient.findById(bill.getCustomerId()));
        bill.getItems().forEach(item -> item.setProduct(productClient.findById(item.getProductId())));
        return bill;
    }
}
