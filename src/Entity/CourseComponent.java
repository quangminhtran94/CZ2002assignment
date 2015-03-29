package Entity;

import java.util.ArrayList;

/**
 * Created by quangminhtran94 on 3/29/15.
 */
public class CourseComponent {
    private int name;
    ArrayList<Student> student;

    public int getName() {
        return name;
    }

    public ArrayList<Student> getStudent() {
        return student;
    }

    public void setStudent(ArrayList<Student> student) {
        this.student = student;
    }

    public void setName(int name) {

        this.name = name;
    }

    public void addStudent(Student s){

    }
}
