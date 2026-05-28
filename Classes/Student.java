package Classes;

import java.util.ArrayList;

public class Student {



    String name;
    long rollNo;
    ArrayList<String>li = new ArrayList<>();


    Student(String name,long rollNo, long id,int number, ArrayList<String> tem){
        this.name = name;
        this.rollNo = rollNo;
        this.li.addAll(tem);

    }

    public int getNumber(){
        return li.size();
    }

}
