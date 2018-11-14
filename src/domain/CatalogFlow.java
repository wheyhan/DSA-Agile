/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
import da.CatalogDA;
import java.util.Objects;

/**
 *
 * @author JianHao
 */
public class CatalogFlow{
       
        private String flower_id;
        private String flower_name;
        private String flower_description;
        private String flower_price;

          public CatalogFlow() {
    }

    public CatalogFlow(String flower_id, String flower_name, String flower_description, String flower_price) {
        this.flower_id = flower_id;
        this.flower_name = flower_name;
        this.flower_description = flower_description;
        this.flower_price = flower_price;
    }

    public String getFlower_id() {
        return flower_id;
    }

    public void setFlower_id(String flower_id) {
        this.flower_id = flower_id;
    }

    public String getFlower_name() {
        return flower_name;
    }

    public void setFlower_name(String flower_name) {
        this.flower_name = flower_name;
    }

    public String getFlower_description() {
        return flower_description;
    }

    public void setFlower_description(String flower_description) {
        this.flower_description = flower_description;
    }

    public String getFlower_price() {
        return flower_price;
    }

    public void setFlower_price(String flower_price) {
        this.flower_price = flower_price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.flower_id);
        hash = 53 * hash + Objects.hashCode(this.flower_name);
        hash = 53 * hash + Objects.hashCode(this.flower_description);
        hash = 53 * hash + Objects.hashCode(this.flower_price);
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
        final CatalogFlow other = (CatalogFlow) obj;
        if (!Objects.equals(this.flower_id, other.flower_id)) {
            return false;
        }
        if (!Objects.equals(this.flower_name, other.flower_name)) {
            return false;
        }
        if (!Objects.equals(this.flower_description, other.flower_description)) {
            return false;
        }
        if (!Objects.equals(this.flower_price, other.flower_price)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Catalog Flower: " + "Flower ID=" + flower_id + ", Flower Name=" + flower_name + ", Flower Description=" + flower_description + ", Flower Price=" + flower_price ;
    }
        

    
}
