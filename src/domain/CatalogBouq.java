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
public class CatalogBouq {
    
        private String bouquets_id;
        private String bouquets_name;
        private String bouquets_description;
        private String bouquets_price;

          public CatalogBouq() {
    }

    public CatalogBouq(String bouquets_id, String bouquets_name, String bouquets_description, String bouquets_price) {
        this.bouquets_id = bouquets_id;
        this.bouquets_name = bouquets_name;
        this.bouquets_description = bouquets_description;
        this.bouquets_price = bouquets_price;
    }

    public String getBouquets_id() {
        return bouquets_id;
    }

    public void setBouquets_id(String bouquets_id) {
        this.bouquets_id = bouquets_id;
    }

    public String getBouquets_name() {
        return bouquets_name;
    }

    public void setBouquets_name(String bouquets_name) {
        this.bouquets_name = bouquets_name;
    }

    public String getBouquets_description() {
        return bouquets_description;
    }

    public void setBouquets_description(String bouquets_description) {
        this.bouquets_description = bouquets_description;
    }

    public String getBouquets_price() {
        return bouquets_price;
    }

    public void setBouquets_price(String bouquets_price) {
        this.bouquets_price = bouquets_price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.bouquets_id);
        hash = 53 * hash + Objects.hashCode(this.bouquets_name);
        hash = 53 * hash + Objects.hashCode(this.bouquets_description);
        hash = 53 * hash + Objects.hashCode(this.bouquets_price);
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
        final CatalogBouq other = (CatalogBouq) obj;
        if (!Objects.equals(this.bouquets_id, other.bouquets_id)) {
            return false;
        }
        if (!Objects.equals(this.bouquets_name, other.bouquets_name)) {
            return false;
        }
        if (!Objects.equals(this.bouquets_description, other.bouquets_description)) {
            return false;
        }
        if (!Objects.equals(this.bouquets_price, other.bouquets_price)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Catalog Bouquet:  " + "Bouquet ID=" + bouquets_id + ", Bouquet Name=" + bouquets_name + ", Bouquet Description=" + bouquets_description + ", Bouquet Price=" + bouquets_price;
    }
          
}
