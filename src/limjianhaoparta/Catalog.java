/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limjianhaoparta;

import da.CatalogFlowerDA;
import da.CatalogBouqDA;
import da.CatalogFloralDA;
import da.PromotionDA;
import java.util.Queue;
import domain.CatalogFlow;
import domain.CatalogBouq;
import domain.Promotion;
import domain.CatalogFloral;
/**
 *
 * @author JianHao
 */
public class Catalog implements CatalogInterface {

    private String flower_id;
    private final CatalogFlowerDA catalog = new CatalogFlowerDA();
    private CatalogBouq catalogBouq = new CatalogBouq();
    private CatalogFlow catalogFlow = new CatalogFlow();
    private CatalogBouqDA catalogBouqDA = new CatalogBouqDA();
    private CatalogFloralDA catalogFloDA = new CatalogFloralDA();
    private Promotion promo = new Promotion();
    private PromotionDA promoDA = new PromotionDA();
    private CatalogFloral catalogFloral = new CatalogFloral();

    @Override
    public Queue showAllFlower() {
        Queue log = catalog.getCurrentRecord();
        
        
        return log;
    }
    public Queue showAllBouq() {
        Queue log = catalogBouqDA.getCurrentRecord();
        
        return log;
    }
    public Queue showAllFloral() {
        Queue log = catalogFloDA.getCurrentRecord();
        
        return log;
    }
    public Queue showAllPromotion(){
        Queue log = promoDA.getCurrentRecord();
        
        return log;
    }
     public void addRecord(CatalogFlow catalogFlow){
        catalog.addRecord(catalogFlow);
        
    }
      public void addRecord(CatalogBouq catalogBouq){
        catalogBouqDA.addRecord(catalogBouq);
        
    }
      public void addRecord(Promotion promo){
          promoDA.addRecord(promo);
      }
      public void addRecord(CatalogFloral catalogFloral){
          catalogFloDA.addRecord(catalogFloral);
      }
         
      public CatalogFlow getFlower(String flower_id){
             
          CatalogFlow catalogFlow = catalog.getFlower(flower_id);       
          return catalogFlow;
      }
      
      public void updateFlower(CatalogFlow catalogFlow){
          catalog.updateFlower(catalogFlow);
      }
      public CatalogBouq getBouq(String bouquets_id){
             
          CatalogBouq catalogBouq = catalogBouqDA.getBouq(bouquets_id);       
          return catalogBouq;
      }
      public void updateBouquet(CatalogBouq catalogBouq){
          catalogBouqDA.updateBouquet(catalogBouq);
      }
          
      
      public void updatePromo(Promotion promo){
          promoDA.updatePromo(promo);
      }
      
   public Promotion getPromo(String promotion_id){
          Promotion promo = promoDA.getPromo(promotion_id);
          return promo;
      }

}
