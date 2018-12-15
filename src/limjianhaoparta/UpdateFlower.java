/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limjianhaoparta;
import domain.CatalogFlow;
import java.util.Scanner;

/**
 *
 * @author JianHao
 */
public class UpdateFlower {
    
    private static final CatalogInterface retrieve = new Catalog();
    private static String flower_status;
    
    public static void UpdateFlower(){
        
        CatalogFlow catalogFlow = new CatalogFlow();
      
        Scanner scanner = new Scanner(System.in);
        
        
            System.out.println("");
            System.out.println("Retrieve Information");
            System.out.println("***********************");
            System.out.print("Enter Flower ID (*F001) : ");
            String flower_id = scanner.nextLine();
            //catalogFlow.setFlower_id(flower_id);
            //CatalogFlow catalog = retrieve.getFlower();
            System.out.println(retrieve.getFlower(flower_id));
            
            
            System.out.println("Update Flower Info");
            System.out.println("***********************");
            System.out.println("");
            System.out.print("Enter Flower ID (*F001) : " + flower_id );
            
            System.out.print("\nFlower Description : ");
            String flower_description = scanner.nextLine();
            System.out.print("Flower Price (*RM99.99) : ");
            String flower_price = scanner.nextLine();
            System.out.print("Flower Quantity : ");
            String flower_quantity = scanner.nextLine();
            
            int a = Integer.parseInt(flower_quantity);
            if(a == 0){
                flower_status = "Out of Stock";
                System.out.println("\nSuccessfully Updated !");
            }else{
                flower_status = "Available";
                System.out.println("\nSuccessfully Updated !");
            }
            retrieve.updateFlower(new CatalogFlow(flower_id, flower_description, flower_price, flower_quantity, flower_status));

            
    }
}
