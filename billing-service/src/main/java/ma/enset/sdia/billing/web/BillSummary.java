package ma.enset.sdia.billing.web;

import ma.enset.sdia.billing.domain.Bill;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BillSummary(Long id, LocalDate issuedOn, Long customerId, int itemCount, BigDecimal total) {

    static BillSummary of(Bill bill) {
        return new BillSummary(bill.getId(), bill.getIssuedOn(), bill.getCustomerId(),
                bill.getItems().size(), bill.getTotal());
    }
}
