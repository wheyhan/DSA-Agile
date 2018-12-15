/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limjianhaoparta;
import da.CatalogBouqDA;
import domain.CatalogBouq;
import java.util.Scanner;
/**
 *
 * @author JianHao
 */
public class UpdateBouquet {
    
private static final CatalogInterface retrieveBouq = new Catalog();
    private static String bouquets_status;
    
    public static void UpdateBouquet(){
        
        CatalogBouq catalogBouq = new CatalogBouq();
      
        Scanner scanner = new Scanner(System.in);
        
        
            System.out.println("");
            System.out.println("Retrieve Bouquet Information");
            System.out.println("***********************");
            System.out.print("Enter Bouquet ID (*B001) : ");
            String bouquets_id = scanner.nextLine();
            //catalogFlow.setFlower_id(flower_id);
            //CatalogFlow catalog = retrieve.getFlower();
            System.out.println(retrieveBouq.getBouq(bouquets_id));
            
            
            System.out.println("Update Bouquet Info");
            System.out.println("***********************");
            System.out.println("");
            System.out.print("Bouquet ID (*B001) : " + bouquets_id );
            
            System.out.print("\nBoquet Description : ");
            String bouquets_description = scanner.nextLine();
            System.out.print("Bouquet Price (*RM99.99) : ");
            String bouquets_price = scanner.nextLine();
            System.out.print("Bouquet Quantity : ");
            String bouquets_quantity = scanner.nextLine();
            
            int a = Integer.parseInt(bouquets_quantity);
            if(a == 0){
                bouquets_status = "Out of Stock";
                System.out.println("\nSuccessfully Updated !");
            }else{
                bouquets_status = "Available";
                System.out.println("\nSuccessfully Updated !");
            }
            retrieveBouq.updateBouquet(new CatalogBouq(bouquets_id, bouquets_description, bouquets_price, bouquets_quantity, bouquets_status));

            
    }
}