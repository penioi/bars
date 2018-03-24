package com.example.bars.model;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PriceIdentity implements Serializable {

    private Long barId;
    private Long productId;

    public Long getBarId() {
        return barId;
    }

    public void setBarId(Long barId) {
        this.barId = barId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PriceIdentity that = (PriceIdentity) o;

        if (barId != null ? !barId.equals(that.barId) : that.barId != null) return false;
        return productId != null ? productId.equals(that.productId) : that.productId == null;
    }

    @Override
    public int hashCode() {
        int result = barId != null ? barId.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        return result;
    }
}
