package Classes;

public class Book {

    String authorName;
    int year;
    int number;

    public Book(String authorName, int year, int number){
        this.authorName = authorName;
        this.year = year;
        this.number = number;
    }
    public String getAuthorName(){
       return authorName;
    }

    public int getYear(){
        return year;
    }

    public int getNumber(){
        return number;
    }
    public void setNumber(){
        this.number --;
    }
}
