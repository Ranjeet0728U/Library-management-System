package Admin;

import java.util.Scanner;
public class Main {

    private static final Scanner sc = new Scanner(System.in);
    static void main(){
        Management mn = new Management();
        try{
            do{
                String information = """
                    Press 1:- for loading information;
                    Press 2: - for adding book into the library
                    press 3:- for add Student Record of the Library;
                    press 4: - to display the all book
                    press 5: - To display the details of the student;
                """;
                System.out.println(information);
                System.out.print("Enter the Number:- ");
                int n = sc.nextInt();

                switch(n){
                    case 1 -> mn.LoadingDetails();
                    case 2 -> mn.addBook();
                    case 3 -> mn.addStdudentRecord();
                    case 4 -> mn.displayBooksDetails();
                    case 5 -> mn.displayStudentDetails();
                }
                if(n>5 || n < 1) break;
            }while(true);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("Executed and completed");
        sc.close();
    }



}
