package Entity;

import java.util.ArrayList;
public class Lecture extends CourseComponent implements java.io.Serializable {
    public Lecture(String name) {
        super(name);
    }

    public Lecture(String name, ArrayList<Student> student) {
        super(name, student);
    }
}
