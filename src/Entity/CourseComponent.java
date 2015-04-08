package Entity;

import java.util.ArrayList;

/**
 * Created by quangminhtran94 on 3/29/15.
 */
public class CourseComponent {
    private String name;
    Course course;
    ArrayList<Student> students;

    /**
     * constructor
     */
    public CourseComponent(String name, Course course){
        this.name = name;
        this.course = course;
        this.students = new ArrayList<Student>();
    }

    public CourseComponent(String name, ArrayList<Student> students) {
        this.name = name;
        this.students = students;
    }

    /**
     * getter and setter method
     */
    public String getName() {
        return name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public ArrayList<Student> getStudent() {
        return students;
    }

    public void setStudent(ArrayList<Student> student) {
        this.students = student;
    }

    public void setName(String name) {
        this.name = name;
    }




    public String toString(){
        return name;
    }

    public void addStudent(Student s){
        this.students.add(s);
    }

    public void printStudent(){
        System.out.println("List of student in "+ this.toString());
        for(Student student:this.students)
            System.out.println(student.getId() + "  " + student.getName());
    }
}
