package ma.enset.sdia.billing.client;

import org.springframework.stereotype.Component;

@Component
class ProductClientFallback implements ProductClient {

    @Override
    public ProductDto findById(Long id) {
        return ProductDto.unavailable(id);
    }
}
