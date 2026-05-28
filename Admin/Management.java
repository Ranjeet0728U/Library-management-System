package Admin;
import Classes.Book;
import Classes.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Management {
    private static final Scanner sc = new Scanner(System.in);
    Map<String, Book> Library = new HashMap<>();
    Map<Integer, String>StudentRecord = new HashMap<>();


/*=======================================================Loading Book==================================================================*/

    public void LoadingDetails(){
        File DetailsFile = new File("./FolderName/BooksDetails.txt");
        File StudentDetails = new File("./FolderName/StudentName.txt");

        /*-------------------------------------Loading Books Details ----------------------------------------------------------------*/
        try (Scanner DetailsRead = new Scanner(DetailsFile)) {
            while(DetailsRead.hasNextLine()){

                String Author = DetailsRead.nextLine();
                if(Author.trim().isEmpty()) continue;

                if(DetailsRead.hasNextLine()){
                    String YearOfPublication = DetailsRead.nextLine();

                    if(DetailsRead.hasNextLine()){
                        String NumberOfBook = DetailsRead.nextLine();

                        if(DetailsRead.hasNextLine()){
                            String BookName = DetailsRead.nextLine();

                            int number = 0;
                            int year = 0;

                            try{
                                number = Integer.parseInt(NumberOfBook);
                            }catch(Exception e){
                                // ignore
                            }

                            try{
                                year = Integer.parseInt(YearOfPublication);
                            }catch (Exception e){
                                //ignore
                            }

                            Book b1 = new Book(Author, year, number);
                            Library.put(BookName, b1);
                        }
                    }
                }
            }
        } catch(Exception e){
            System.out.println("Exeception occured");
        }
        /*-----------------------------------------------Loading Student Record---------------------------------------------------------*/
        try(Scanner StudentReader = new Scanner(StudentDetails)){

            while(StudentReader.hasNextLine()){

                String name = StudentReader.nextLine();
                int id = 0;

                if(StudentReader.hasNextLine()) {

                    id = Integer.parseInt(StudentReader.nextLine());

                    if(StudentReader.hasNextLine()) StudentReader.nextLine();

                }else {
                    throw new RuntimeException("Failed to load the data");
                }

                StudentRecord.put(id, name);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

/*============================================================Add New Book===============================================================*/
    public void addBook(){
        try {

            try(FileWriter fw = new FileWriter("./FolderName/BooksDetails.txt",true)) {
                System.out.print("Enter the Name of the Author");
                String authorName = sc.nextLine();
                fw.write(authorName + "\n");

                System.out.print("Enter the Year of Publication:- ");
                int year = sc.nextInt();
                fw.write(year + "\n");

                System.out.print("Enter the Number of Book in the library:- ");
                int numberOfBooks = sc.nextInt();
                fw.write(numberOfBooks + "\n");

                sc.nextLine();
                System.out.print("Enter the name of the Book:- ");
                String BookName = sc.nextLine();
                fw.write(BookName + "\n");
                System.out.println();

                fw.write("\n");

                Book b1 = new Book(authorName, year, numberOfBooks);
                Library.put(BookName,b1);
            }
            LoadingDetails();
        }
        catch (IOException e) {
            System.out.println("Cannot find that file");
        }
    }

/*============================================================================Display Books details======================================================*/

    public void displayBooksDetails(){
        for(Map.Entry<String,Book>BookDetails : Library.entrySet()){
            System.out.println("Book :- " + BookDetails.getKey() + "||\tAuthor Name: - " + BookDetails.getValue().getAuthorName() +"||\t Publication Year:- "+ BookDetails.getValue().getYear() + "||\t Number of Books:- " + BookDetails.getValue().getNumber());
        }
        System.out.println();
    }

/*=================================================Book Assigned to Student=======================================================*/




/*=================================================Assigning the value=======================================================*/

//    public void reWritting(){
//        try(FileWriter Details = new FileWriter("./FolderName/BooksDetails.txt")) {
//
//            for(Map.Entry<String, Book> mp : Library.entrySet()){
//                Details.write(mp.getKey() +"\n");
//                Details.write(mp.getValue().getNumber());
//                Details.write(mp.getValue().getAuthorName());
//                Details.write(mp.getValue().getYear());
//                Details.write("\n");
//
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }


/*=================================================Adding the Student record=======================================================*/

    public void addStdudentRecord(){
        try{
            try(FileWriter fl = new FileWriter("./FolderName/StudentName.txt",true)){
                System.out.println("Enter the number of Student to add: in list");
                int n = sc.nextInt();
                sc.nextLine();
                int i = 0;
                while(i < n){
                    System.out.print("Enter the Name:- ");
                    String name = sc.nextLine();
                    System.out.println("Enter the ID of the student");
                    int id = sc.nextInt();
                    sc.nextLine();

                    fl.write(name+"\n");
                    fl.write(id +"\n");
                    fl.write("\n");
                    i++;
                    if(i == n){
                        System.out.print("Want to add more details? :- ");
                        n += sc.nextInt();
                    }
                }
            }
        }catch(Exception e){
            System.out.println("Loading failed");
        }
    }


/*=================================================Display the information of the Student=======================================================*/
    public void displayStudentDetails(){
        File StudentDetails = new File("./FolderName/StudentName.txt");
        try(Scanner StudentDetailReading = new Scanner(StudentDetails)){
            while(StudentDetailReading.hasNextLine()){
                String name = StudentDetailReading.nextLine();
                if(name.trim().isEmpty()){
                    continue;
                }
                if(StudentDetailReading.hasNextLine()){
                    String id = StudentDetailReading.nextLine();
                    System.out.println("The ID of " + name + "is:- " + id);
                }
                if(StudentDetailReading.hasNextLine()) StudentDetailReading.nextLine();
            }
        }catch(Exception e){
            System.out.println("File loading fail!");
        }
    }












}
