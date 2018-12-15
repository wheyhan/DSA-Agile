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
public class CatalogMenu {
    
    public static void main(String[]args){
    
          Scanner scanner = new Scanner(System.in);

        int select;
        
        do {
            System.out.println("");
            System.out.println("Catalaog Menu");
            System.out.println("***********************");
            System.out.println("1.Add New Product/Promotion");
            System.out.println("2.View All Product/Promotion");
            System.out.println("3.Update Product/Promotion Information");
            System.out.println("***********************");
            
            System.out.print("Please Enter Your Selection :");
            
            
            select= scanner.nextInt();
            switch (select) {
                case 1:
                    AddProduct addProduct = new AddProduct();
                    addProduct.AddProduct();
                    break;
                case 2: 
                    First first = new First();
                    first.View();
                    break;
                case 3:
                    ViewUpdate viewUpdate = new ViewUpdate();
                    viewUpdate.ViewUpdate();
                    break;     
                default:
                    System.out.println("\nPlease Re-enter your SELECTION!");
                    break;
            }

        } while (select > 1);

        
    
    }
    
}
