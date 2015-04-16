package Control;

import Entity.Course;
import Entity.Student;

import java.util.ArrayList;

/**
 * Control class for student
 */
public class StudentManager {
    public StudentManager() {
    }

    /**
     * create a student s
     * @param s student
     */
    public void create(Student s){
        s.create();
        System.out.print("\n\n");
    }


    /**
     *print transcript of student s
     * @param s student
     */
    public void printTranscript(Student s){
        s.printTranscript();
        System.out.print("\n\n");
    }

    /**
     * print student list
     * @param students list of students
     */
    public void printStudentsList(ArrayList<Student> students){
        for (int i = 0; i < students.size(); i++)
            System.out.println((i+1) +". " + students.get(i).toString());
        System.out.print("\n\n");
    }
}
