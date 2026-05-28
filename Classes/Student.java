package Admin;

import java.util.ArrayList;

public class Student {

    private static class BookAssigned{
        int number;
        String nameOfBook;
        BookAssigned(int number, String nameOfBook){
            this.number = number;
            this.nameOfBook = nameOfBook;
        }
    }
    long rollNo;
    long id;
    ArrayList<BookAssigned>li = new ArrayList<>();

    Student(long rollNo, long id, ArrayList<BookAssigned> tem){
        this.id = id;
        this.rollNo = rollNo;
        this.li.add(tem);
    }

}
