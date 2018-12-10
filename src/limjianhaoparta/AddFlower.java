/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limjianhaoparta;
import da.CatalogDA;
import domain.CatalogFlow;

import java.util.Scanner;

/**
 *
 * @author JianHao
 */
public class AddFlower {
    
    public static void main(String[] args) {
        
         CatalogInterface catFlow = new CatalogFlower();
         Scanner scan = new Scanner(System.in);
         
            System.out.println("");
            System.out.println("New Flower Insert");
            System.out.println("***********************");
             System.out.println("");
            System.out.print("Flower ID (*F001) : ");
            String flower_id = scan.nextLine();
            System.out.println("Flower Name :\t");
            String flower_name = scan.nextLine();
            System.out.println("Flower Description :\t");
            String flower_description = scan.nextLine();
            System.out.println("Flower Price (*RM99.99) :\t");
            String flower_price = scan.nextLine();
            System.out.println("Flower Status :\t");
            String flower_status = scan.nextLine();
            
            System.out.println("\nSuccessfully Added !");
         
            catFlow.addRecord(new CatalogFlow(flower_id, flower_name, flower_description, flower_price, flower_status));
     
        
    }
}


