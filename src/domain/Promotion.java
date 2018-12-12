/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Objects;

/**
 *
 * @author JianHao
 */
public class Promotion {
    private String promotion_month;
    private String product_type;
    private String product;
    private String discount;
    private String promotion_status;
    
    public Promotion(){
    
}

    public Promotion(String promotion_month, String product_type, String product, String discount, String promotion_status) {
        this.promotion_month = promotion_month;
        this.product_type = product_type;
        this.product = product;
        this.discount = discount;
        this.promotion_status = promotion_status;
    }

    public String getPromotion_month() {
        return promotion_month;
    }

    public void setPromotion_month(String promotion_month) {
        this.promotion_month = promotion_month;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPromotion_status() {
        return promotion_status;
    }

    public void setPromotion_status(String promotion_status) {
        this.promotion_status = promotion_status;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.promotion_month);
        hash = 29 * hash + Objects.hashCode(this.product_type);
        hash = 29 * hash + Objects.hashCode(this.product);
        hash = 29 * hash + Objects.hashCode(this.discount);
        hash = 29 * hash + Objects.hashCode(this.promotion_status);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Promotion other = (Promotion) obj;
        if (!Objects.equals(this.promotion_month, other.promotion_month)) {
            return false;
        }
        if (!Objects.equals(this.product_type, other.product_type)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        if (!Objects.equals(this.discount, other.discount)) {
            return false;
        }
        if (!Objects.equals(this.promotion_status, other.promotion_status)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nPromotion_month = " + promotion_month +"\n"+ "Product Type = " + product_type +"\n" +"Product = " + product + "\n" +"Discount = " + discount +"\n" +"Promotion Status = " + promotion_status + "\n\n";
    }
    
    
}
