package nauka.zbiory.two;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProductMenager {
    private static final int ADD_PRODUCT = 0;
    private static final int EXIT = 1;
    private static final int DISCARD_PRODUCT = 0;
    private static final int MODIFY_PRODUCT = 1;

    private Set<Product> products = new HashSet<>();
    private Scanner sc = new Scanner(System.in);


    public void mainLoop(){
        int number;
        do {
            optionInfo();
            number = readOption();
            evaluateOption(number);

        }while (number != EXIT);
    }

    private int readOption() {
        System.out.println("Wybierz opcje");
        int scaner = sc.nextInt();
        sc.nextLine();
        return scaner;
    }

    private void evaluateOption(int number) {
        if(number == ADD_PRODUCT){
            addNextProduct();
        }else if(number == EXIT){
           printProducts();
        }else if(number == 2){
            printProducts();
        }else
            System.out.println("nieznan opcja");
    }

    private void printProducts() {
        System.out.println("Lista produktow");
        for (Product product : products) {
            System.out.println(product);

        }
    }


    private void addNextProduct() {
        Product product = createProduct();
        if (products.contains(product)){
            askAndReplace(product);
        }else {
            addProduct(product);
        }

    }

    private void askAndReplace(Product product) {
        System.out.println("Znaleziono produkt o takiej nazwie, wybierz co chcesz zrobić");
        System.out.println(" > Zignoruj produkt - " + DISCARD_PRODUCT);
        System.out.println(" > Nadpisz produkt - " + MODIFY_PRODUCT);
        int option = sc.nextInt();
        sc.nextLine();
        if(option == MODIFY_PRODUCT){
            products.remove(product);
            addProduct(product);
        }
    }

    private void addProduct(Product product) {
        products.add(product);
        System.out.println("dodano produkt");
    }

    private Product createProduct() {
        System.out.println("podaj nazwe");
        String name = sc.nextLine();
        System.out.println("podaj cene");
        double price = sc.nextDouble();
        return new Product(name, price);
    }

    private void optionInfo() {
        System.out.println("Opcje :");
        System.out.println("> dodaj produkt :" + ADD_PRODUCT);
        System.out.println("> koniec programu :" + EXIT);
        System.out.println("lista peoduktow : 2" );
    }




}
