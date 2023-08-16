package nauka.mapy.one;

import java.util.Scanner;

public class CompanyApp {

    private static final int ADD_EMPLOYEE = 0;
    private static final int FIND_EMPLOYEE = 1;
    private static final int EXIT = 2;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Company company = new Company();
        int userOption;

        do {
            printOption();
            System.out.println("wybiez opcje");
            userOption = sc.nextInt();
            sc.nextLine();
            switch (userOption){
                case ADD_EMPLOYEE -> {
                    Employee employee = readEndCreateCmployee();
                    company.addEmployee(employee);
                }

                case FIND_EMPLOYEE ->
                    findEmployee(company);

                case EXIT -> System.out.println("koniec programu");
            }

        }while (userOption!=EXIT);
    }

    private static Employee readEndCreateCmployee(){
        System.out.println("Podaj imie");
        String firstName = sc.nextLine();
        System.out.println("Podaj nazwisko");
        String lastName = sc.nextLine();
        System.out.println("Podaj wyplate");
        double salary = sc.nextDouble();

        return new Employee(firstName, lastName, salary);
    }

    private static void findEmployee(Company company){
        System.out.println("Podaj Imie");
        String firstName = sc.nextLine();
        System.out.println("podaj nazwisko");
        String lastName = sc.nextLine();
        Employee employee = company.getEmploye(firstName,lastName);
        if (employee == null){
            System.out.println("Brak danych");
        }else {
            System.out.println(employee);
        }
    }


    private static void printOption(){
        System.out.println(ADD_EMPLOYEE + "Dodanie pracownika");
        System.out.println(FIND_EMPLOYEE + "Znajdz pracownika");
        System.out.println(EXIT + "Wyjdz");
    }


}
