package Entity;

import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Course> courses;

    public Student(String name) {
        this.name = name;
    }

    public void addCourse(Course c){
        if (courses.contains(c)){
            System.out.println("This student has already taken this course");
        }else{
            this.courses.add(c);
            c.addStudent(this);
        }
    }
}
