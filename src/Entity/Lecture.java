package Entity;

import java.util.ArrayList;
public class Lecture extends CourseComponent implements java.io.Serializable {
    public Lecture(String name, Course course) {
        super(name, course);
    }

    public Lecture(String name, ArrayList<Student> students) {
        super(name, students);
    }
}
