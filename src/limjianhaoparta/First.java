/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limjianhaoparta;

import domain.CatalogFlow;
import da.CatalogDA;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author JianHao
 */
public class First {
    
    
     private static final CatalogInterface catFlower = new CatalogFlower();
     
     public static void main(String[] args) {
         
         Scanner scanner = new Scanner(System.in);

        int select;
        
        do {
            System.out.println("");
            System.out.println("PRODUCT LIST");
            System.out.println("***********************");
            System.out.println("1. Fresh Flower");
            System.out.println("2. Bouquets");
            System.out.println("3. Floral Arrangement");
            System.out.println("***********************");
            
            System.out.print("Please Enter Your Selection :");
            
            
            select= scanner.nextInt();
            switch (select) {
                case 1:
                    System.out.println(catFlower.showAllFlower());
                    break;
                case 2: 
                    System.out.println(catFlower.showAllBouq());
                    break;
                case 3:
                    System.out.println(catFlower.showAllFloral());
                    break;
                default:
                    System.out.println("Please Re-enter your SELECTION!");
                    break;
            }

        } while (select > 1);

        }
}