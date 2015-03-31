package Entity;

import java.util.ArrayList;

/**
 * Created by quangminhtran94 on 3/29/15.
 */
public class CourseComponent {
    private String name;
    ArrayList<Student> student;

    /**
     * constructor
     */
    public CourseComponent(String name){
        this.name = name;
        this.student = new ArrayList<Student>();
    }

    public CourseComponent(String name, ArrayList<Student> student) {
        this.name = name;
        this.student = student;
    }

    /**
     * getter and setter method
     */
    public String getName() {
        return name;
    }

    public ArrayList<Student> getStudent() {
        return student;
    }

    public void setStudent(ArrayList<Student> student) {
        this.student = student;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return name;
    }

    public void addStudent(Student s){

    }

    public void printStudent(){

    }
}
