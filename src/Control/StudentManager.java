package Control;

import Entity.Course;
import Entity.Student;

import java.util.ArrayList;

/**
 * Created by quangminhtran94 on 4/15/15.
 */
public class StudentManager {
    public StudentManager() {
    }

    public void create(Student s){
        s.create();
    }

    public void addStudent(Student s, Course c){
        s.addCourse(c);
    }

    public void printTranscript(Student s){
        s.printTranscript();
    }

    public void printStudentsList(ArrayList<Student> students){
        for (int i = 0; i < students.size(); i++)
            System.out.println((i+1) +". " + students.get(i).toString());
    }
}
