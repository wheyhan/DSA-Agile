/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limjianhaoparta;
import da.PromotionDA;
import domain.Promotion;
import java.util.Scanner;

/**
 *
 * @author JianHao
 */
public class AddPromotion {
    public static void main(String[] args) {
        
         CatalogInterface promo = new CatalogFlower();
         Scanner scan = new Scanner(System.in);
         
            System.out.println("");
            System.out.println("New Monthly Promotion");
            System.out.println("***********************");
             System.out.println("");
            System.out.print("Promotion Month : ");
            String promotion_month = scan.nextLine();
            System.out.println("Product Type :\t");
            String product_type = scan.nextLine();
            System.out.println("Product :\t");
            String product = scan.nextLine();
            System.out.println("Discount (*10%) :\t");
            String discount = scan.nextLine();
            System.out.println("Promotion Status :\t");
            String promotion_status = scan.nextLine();
            
            System.out.println("\nSuccessfully Added !");
         
            promo.addRecord(new Promotion(promotion_month, product_type, product, discount, promotion_status));
     
        
    }
}
