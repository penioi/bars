package com.example.bars;

import com.example.bars.model.Bar;
import com.example.bars.model.Product;

import java.io.Serializable;
import java.math.BigDecimal;


    public   class BarPrices implements Serializable {

        private Bar bar;

        private Iterable<ProductPrice> menu;

        public BarPrices(Bar bar, Iterable<ProductPrice> menu) {
            this.bar = bar;
            this.menu = menu;
        }

        public Bar getBar() {
            return bar;
        }

        public Iterable<ProductPrice> getMenu() {
            return menu;
        }

        static class ProductPrice{
            private Product product;
            private BigDecimal price;

            public ProductPrice(Product product, BigDecimal price) {
                this.product = product;
                this.price = price;
            }

            public Product getProduct() {
                return product;
            }

            public void setProduct(Product product) {
                this.product = product;
            }

            public BigDecimal getPrice() {
                return price;
            }

            public void setPrice(BigDecimal price) {
                this.price = price;
            }
        }

    }

