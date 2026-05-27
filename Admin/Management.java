package Admin;
import Classes.Book;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Management {
    private static Scanner sc = new Scanner(System.in);
    Map<String, Book> Library = new HashMap<>();


    /*=================================================Loading Book=======================================================*/

    public void LoadingDetails(){
        File AuthorNameFile = new File("./FolderName/AuthorName.txt");
        File BookNameFile = new File("./FolderName/BookName.txt");
        File NumberFile = new File("./FolderName/Number.txt");
        File PublishYearFile = new File("./FolderName/PublishYear.txt");

        try (
                Scanner authorReader = new Scanner(AuthorNameFile);
                Scanner BookNameReader = new Scanner(BookNameFile);
                Scanner NumberReader = new Scanner(NumberFile);
                Scanner PublishYearReader = new Scanner(PublishYearFile)
        ) {
            while(
                    authorReader.hasNextLine()
                    && BookNameReader.hasNextLine()
                    && NumberReader.hasNextLine()
                    && PublishYearReader.hasNextShort()
            ){
                String Author = authorReader.nextLine();
                String BookName = BookNameReader.nextLine();
                String NumberOfBook = NumberReader.nextLine();
                String YearOfPublication = PublishYearReader.nextLine();

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

        } catch(Exception e){
            System.out.println("Exeception occured");
        }
    }

/*=================================================Add New Book=======================================================*/
    public void addBook(){
        try {

            try(FileWriter AuthorNameFile = new FileWriter("./FolderName/AuthorName.txt", true);
                FileWriter BookNameFile = new FileWriter("./FolderName/BookName.txt",true);
                FileWriter NumberFile = new FileWriter("./FolderName/Number.txt",true);
                FileWriter PublicYearFile = new FileWriter("./FolderName/PublishYear.txt",true)
            ) {
                System.out.print("Enter the Name of the Author");
                String authorName = sc.nextLine();
                AuthorNameFile.write(authorName + "\n");

                System.out.println("Enter the Year of Publication:- ");
                int year = sc.nextInt();
                PublicYearFile.write(year + "\n");

                System.out.println("Enter the Number of Book in the library:- ");
                int numberOfBooks = sc.nextInt();
                NumberFile.write(numberOfBooks + "\n");

                sc.nextLine();
                System.out.println("Enter the name of the Book:- ");
                String BookName = sc.nextLine();
                BookNameFile.write(BookName + "\n");

                Book b1 = new Book(authorName, year, numberOfBooks);
                Library.put(BookName,b1);
            }
        }
        catch (IOException e) {
            System.out.println("Cannot find that file");
        }
    }

    public void display(){
        for(Map.Entry<String,Book>BookDetails : Library.entrySet()){
            System.out.println("Book :- " + BookDetails.getKey() + "\tAuthor Name: - " + BookDetails.getValue().getAuthorName() +"\t Publication Year:- "+ BookDetails.getValue().getYear() + "\t Number of Books:- " + BookDetails.getValue().getNumber());
        }
    }



}
