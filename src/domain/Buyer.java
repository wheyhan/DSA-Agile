/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Chun Haur Lim
 */
public class Buyer {
    private String id;
    private String name;
    private String ic;

     public Buyer() {
        
    }
    public Buyer(String id, String name, String ic) {
        this.id = id;
        this.name = name;
        this.ic = ic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    @Override
    public String toString() {
        return "Buyer{" + "id=" + id + ", name=" + name + ", ic=" + ic + '}';
    }
    
}
