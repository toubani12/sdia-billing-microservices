package ma.enset.sdia.billing.web;

import ma.enset.sdia.billing.domain.Bill;
import ma.enset.sdia.billing.service.BillQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    private final BillQueryService billQueryService;

    public BillController(BillQueryService billQueryService) {
        this.billQueryService = billQueryService;
    }

    // lightweight listing: no remote calls, customer/product are not resolved
    @GetMapping
    public List<BillSummary> list() {
        return billQueryService.findAll().stream().map(BillSummary::of).toList();
    }

    @GetMapping("/{id}")
    public Bill details(@PathVariable Long id) {
        return billQueryService.findDetailed(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<Bill> byCustomer(@PathVariable Long customerId) {
        return billQueryService.findDetailedByCustomer(customerId);
    }
}
