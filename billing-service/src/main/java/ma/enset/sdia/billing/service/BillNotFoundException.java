package ma.enset.sdia.billing.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BillNotFoundException extends RuntimeException {

    public BillNotFoundException(Long id) {
        super("Bill " + id + " not found");
    }
}
