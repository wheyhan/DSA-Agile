/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limjianhaoparta;
import da.CatalogFloralDA;
import domain.CatalogFloral;

import java.util.Scanner;

/**
 *
 * @author JianHao
 */
public class AddFloral {
    
    public static void main(String[] args) {
        
         CatalogInterface catFloral = new CatalogFlower();
         Scanner scan = new Scanner(System.in);
         
            System.out.println("");
            System.out.println("New Arrangement Insert");
            System.out.println("***********************");
             System.out.println("");
            System.out.print("Arrangement ID (*FL001) : ");
            String floral_id = scan.nextLine();
            System.out.println("Name :\t");
            String floral_name = scan.nextLine();
            System.out.println("Description :\t");
            String floral_description = scan.nextLine();
          
            
            System.out.println("\nSuccessfully Added !");
         
            catFloral.addRecord(new CatalogFloral(floral_id, floral_name, floral_description));
     
        
    }
}


