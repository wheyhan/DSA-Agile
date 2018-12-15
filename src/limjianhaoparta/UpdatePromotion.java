/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limjianhaoparta;

import domain.Promotion;
import java.util.Scanner;

/**
 *
 * @author JianHao
 */
public class UpdatePromotion {
    
    private static final CatalogInterface retrievePromo = new Catalog();
    private static String product_type;
    
    public static void UpdatePromotion(){
        
        Promotion promotion = new Promotion();
      
        Scanner scanner = new Scanner(System.in);
        
        
            System.out.println("");
            System.out.println("Retrieve Promotion Info");
            System.out.println("***********************");
            System.out.print("Enter Promotion ID (*P001) : ");
            String promotion_id = scanner.nextLine();
            System.out.println(retrievePromo.getPromo(promotion_id));
                       
            System.out.println("Update Promotion Info");
            System.out.println("***********************");
            System.out.println("");
            System.out.print("Enter Promotion ID (*P001) : " + promotion_id );
            
            System.out.print("\nPromotion Month : ");
            String promotion_month = scanner.nextLine();
             System.out.println("Product Type :\t");
            System.out.println("1.Flower");
            System.out.println("2.Bouquet");
            System.out.print("Please Enter Your Selection : ");
            String product_type = scanner.nextLine();  
            int a = Integer.parseInt(product_type);
            if(a == 1){
                product_type = "Flower";
                
            }else if(a == 2){
                product_type = "Bouquet";
               
            }else{
            System.out.println("\nPlease Re-enter your SELECTION!");
            }
            
            System.out.print("Product :");
            String product = scanner.nextLine();
            System.out.print("Discount (*10%) : ");
            String discount = scanner.nextLine();
            System.out.print("Promotion Status :");
            String promotion_status = scanner.nextLine();
            
            System.out.println("\nSuccessfully Updated !");
            retrievePromo.updatePromo(new Promotion(promotion_id, promotion_month, product_type, product, discount, promotion_status));

            
    }
}
