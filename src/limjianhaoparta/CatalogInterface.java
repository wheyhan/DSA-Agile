/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limjianhaoparta;

import java.util.Queue;
import domain.CatalogFlow;
import domain.CatalogBouq;
import domain.Promotion;
import domain.CatalogFloral;

/**
 *
 * @author JianHao
 */
public interface CatalogInterface {
    
    Queue showAllFlower();
    Queue showAllBouq();
    Queue showAllFloral();
    Queue showAllPromotion();
    void addRecord(CatalogFlow catalogFlow);
    void addRecord(CatalogBouq catalogBouq);
    void addRecord(Promotion promo);
    void addRecord(CatalogFloral catalogFloral);
}
