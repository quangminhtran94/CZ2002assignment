package Entity;

import java.util.ArrayList;
public class Lecture extends CourseComponent implements java.io.Serializable {
    public Lecture(String name, Course course, int vacancy) {
        super(name, course, vacancy);
    }

    public Lecture(String name, ArrayList<Student> students) {
        super(name, students);
    }
}
