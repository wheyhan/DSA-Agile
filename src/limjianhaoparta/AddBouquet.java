
package limjianhaoparta;
import da.CatalogBouqDA;
import domain.CatalogBouq;

import java.util.Scanner;

/**
 *
 * @author JianHao
 */
public class AddBouquet {
    
    public static void main(String[] args) {
        
         CatalogInterface catBouq = new CatalogFlower();
         Scanner scan = new Scanner(System.in);
         
            System.out.println("");
            System.out.println("New Bouquet Insert");
            System.out.println("***********************");
             System.out.println("");
            System.out.print("Bouquet ID (*B001) : ");
            String bouquet_id = scan.nextLine();
            System.out.println("Bouquet Name :\t");
            String bouquet_name = scan.nextLine();
            System.out.println("Bouquet Description :\t");
            String bouquet_description = scan.nextLine();
            System.out.println("Bouquet Price (*RM99.99) :\t");
            String bouquet_price = scan.nextLine();
            System.out.println("Bouquet Status :\t");
            String bouquet_status = scan.nextLine();
            
            System.out.println("\nSuccessfully Added !");
         
            catBouq.addRecord(new CatalogBouq(bouquet_id, bouquet_name, bouquet_description, bouquet_price, bouquet_status));
     
        
    }
}

