/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limjianhaoparta;

import java.util.Scanner;

/**
 *
 * @author JianHao
 */
public class ViewUpdate {
    
    private static final CatalogInterface update = new Catalog();
    
    public static void ViewUpdate(){
        Scanner scanner = new Scanner(System.in);
        
        int select;
        
        do{
             System.out.println("");
            System.out.println("Update Product");
            System.out.println("***********************");
            System.out.println("1. Update Flower Information");
            System.out.println("2. Update Bouquet Information");
            System.out.println("3. Update Monthly Promotion Information");
            
            System.out.println("***********************");
            
            System.out.print("Please Enter Your Selection :");
            
            
            select= scanner.nextInt();
            switch (select) {
                case 1:
                    UpdateFlower updateFlower = new UpdateFlower();
                    updateFlower.UpdateFlower();
                    break;
                case 2: 
                    UpdateBouquet updateBouquet = new UpdateBouquet();
                    updateBouquet.UpdateBouquet();
                    break;
                case 3:
                    UpdatePromotion updatePromotion = new UpdatePromotion();
                    updatePromotion.UpdatePromotion();
                default:
                    System.out.println("\nPlease Re-enter your SELECTION!");
                    break;
            }

        } while (select > 1);
        
    }
    
}
