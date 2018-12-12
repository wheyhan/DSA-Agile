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
    private String pwd;
    
     public Buyer() {
        
    }
     
    public Buyer(String id, String name, String ic) {
        this.id = id;
        this.name = name;
        this.ic = ic;
    }

    public Buyer(String id, String name, String ic, String pwd) {
        this.id = id;
        this.name = name;
        this.ic = ic;
        this.pwd = pwd;
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    
    @Override
    public String toString() {
        return "ID: "+id+"\nName: "+name+"\nIC: "+ic+"\nPwd: "+pwd;
    }
    
}
