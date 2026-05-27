package Admin;

import java.util.Scanner;
public class main {

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        Management mn = new Management();
        do{
            String information = """
                    Press 1:- for loading information;
                    Press 2: - for adding book into the library
                    press 3: - to display the all book 
                """;
            System.out.println(information);
            System.out.print("Enter:- ");
            int n = sc.nextInt();

            switch(n){
                case 1 -> mn.LoadingDetails();
                case 2 -> mn.addBook();
                case 3 -> mn.display();
            }
            if(n>3 || n < 1) break;
        }while(true);

        System.out.println("Executed and completed");


        sc.close();


    }
}
