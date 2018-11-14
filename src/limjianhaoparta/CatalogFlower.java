/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limjianhaoparta;

import da.CatalogDA;
import da.CatalogBouqDA;
import da.CatalogFloralDA;
import java.util.Queue;

/**
 *
 * @author JianHao
 */
public class CatalogFlower implements CatalogInterface {

    private CatalogDA catalog = new CatalogDA();
    private CatalogBouqDA catalogBouq = new CatalogBouqDA();
    private CatalogFloralDA catalogFlo = new CatalogFloralDA();

    @Override
    public Queue showAllFlower() {
        Queue log = catalog.getCurrentRecord();
        
        return log;
    }
    public Queue showAllBouq() {
        Queue log = catalogBouq.getCurrentRecord();
        
        return log;
    }
 public Queue showAllFloral() {
        Queue log = catalogFlo.getCurrentRecord();
        
        return log;
    }
}
