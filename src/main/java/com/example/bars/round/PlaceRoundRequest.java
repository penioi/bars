package com.example.bars.round;


public class PlaceRoundRequest {

    private Long barId;
    private Iterable<OrderedProduct> orderedProducts;

    public PlaceRoundRequest() {
    }

    public PlaceRoundRequest(Long barId, Iterable<OrderedProduct> orderedProducts) {
        this.barId = barId;
        this.orderedProducts = orderedProducts;
    }

    public Long getBarId() {
        return barId;
    }

    public Iterable<OrderedProduct> getOrderedProducts() {
        return orderedProducts;
    }

    static class OrderedProduct {
        private Long productId;
        private Integer quantity;

        public OrderedProduct() {
        }

        public OrderedProduct(Long productId, Integer quantity) {
            this.productId = productId;
            this.quantity = quantity;
        }

        public Long getProductId() {
            return productId;
        }

        public Integer getQuantity() {
            return quantity;
        }
    }
}
