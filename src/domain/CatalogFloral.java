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
public class CatalogFloral {
        private String floral_id;
        private String floral_name;
        private String floral_description;
        private String floral_price;
        
        public CatalogFloral(){
    
}

    public CatalogFloral(String floral_id, String floral_name, String floral_description, String floral_price) {
        this.floral_id = floral_id;
        this.floral_name = floral_name;
        this.floral_description = floral_description;
        this.floral_price = floral_price;
    }

    public String getFloral_id() {
        return floral_id;
    }

    public void setFloral_id(String floral_id) {
        this.floral_id = floral_id;
    }

    public String getFloral_name() {
        return floral_name;
    }

    public void setFloral_name(String floral_name) {
        this.floral_name = floral_name;
    }

    public String getFloral_description() {
        return floral_description;
    }

    public void setFloral_description(String floral_description) {
        this.floral_description = floral_description;
    }

    public String getFloral_price() {
        return floral_price;
    }

    public void setFloral_price(String floral_price) {
        this.floral_price = floral_price;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.floral_id);
        hash = 97 * hash + Objects.hashCode(this.floral_name);
        hash = 97 * hash + Objects.hashCode(this.floral_description);
        hash = 97 * hash + Objects.hashCode(this.floral_price);
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
        final CatalogFloral other = (CatalogFloral) obj;
        if (!Objects.equals(this.floral_id, other.floral_id)) {
            return false;
        }
        if (!Objects.equals(this.floral_name, other.floral_name)) {
            return false;
        }
        if (!Objects.equals(this.floral_description, other.floral_description)) {
            return false;
        }
        if (!Objects.equals(this.floral_price, other.floral_price)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Catalog Floral: " + "Floral ID=" + floral_id + ", Floral Name=" + floral_name + ", Floral Description=" + floral_description + ", Floral Price=" + floral_price;
    }

}
