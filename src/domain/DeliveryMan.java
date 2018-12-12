/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Objects;

/**
 *
 * @author user
 */
public class DeliveryMan {

    private String dManID;
    private String dManIC;
    private String dManName;
    public DeliveryMan next;

    public DeliveryMan(String dManID, String dManIC, String dManName) {
        this.dManID = dManID;
        this.dManIC = dManIC;
        this.dManName = dManName;
    }

    public String getdManID() {
        return dManID;
    }

    public String getdManIC() {
        return dManIC;
    }

    public String getdManName() {
        return dManName;
    }

    public void setdManID(String dManID) {
        this.dManID = dManID;
    }

    public void setdManIC(String dManIC) {
        this.dManIC = dManIC;
    }

    public void setdManName(String dManName) {
        this.dManName = dManName;
    }

    @Override
    public String toString() {
        return "DeliveryMan{" + "dManID=" + dManID + ", dManIC=" + dManIC + ", dManName=" + dManName + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.dManID);
        hash = 97 * hash + Objects.hashCode(this.dManIC);
        hash = 97 * hash + Objects.hashCode(this.dManName);
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
        final DeliveryMan other = (DeliveryMan) obj;
        if (!Objects.equals(this.dManID, other.dManID)) {
            return false;
        }
        if (!Objects.equals(this.dManIC, other.dManIC)) {
            return false;
        }
        if (!Objects.equals(this.dManName, other.dManName)) {
            return false;
        }
        return true;
    }
    
    public void Display(){
        
        System.out.format("%-17s%-17s%-19s", 
                dManID, dManIC, dManName);
    }
}
