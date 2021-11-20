
package services;

import java.util.ArrayList;
import java.util.List;
import models.Student;


public class StudentServices {
    public static List <Student> students = new ArrayList<>();
    
    public static List<Student> getStudents(){
    //Add sample data
    students.add(new Student("Reema", "Ahmad", "reema@gmail.com"));
    students.add(new Student("Reema", "Ahmad", "reema@gmail.com"));
   
    //return the list
    return students;
    
    }
    
}
