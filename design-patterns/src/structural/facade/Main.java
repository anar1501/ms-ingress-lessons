package structural.facade;

import structural.facade.enums.PhoneType;
import structural.facade.factory.GetSaleFactory;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        var getSaleFactory = new GetSaleFactory();
        System.out.print("========= Mobile Shop ============ \n");
        System.out.print("            1. IPHONE.              \n");
        System.out.print("            2. SAMSUNG.              \n");
        System.out.print("            3. BLACKBERRY.            \n");
        System.out.print("            4. Exit.                     \n");
        System.out.print("Enter your choice: ");
        var sale = getSaleFactory.getSale(PhoneType.valueOf(new Scanner(System.in).nextLine().toUpperCase()));
        ShopKeeper.doOperation(sale);
    }
}

