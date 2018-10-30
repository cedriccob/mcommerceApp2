package com.clientui.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String produit_non_trouvé) {
        super(produit_non_trouvé);
    }
}
