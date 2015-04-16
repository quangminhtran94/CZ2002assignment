package Entity;

import java.util.ArrayList;

/**
 * Created by quangminhtran94 on 3/29/15.
 */
public class CourseComponent {
    private String name;
    Course course;
    ArrayList<Student> students;
    int vacancy;

    /**
     * constructor
     */
    public CourseComponent(String name, Course course, int vacancy){
        this.name = name;
        this.course = course;
        this.students = new ArrayList<Student>();
        this.vacancy = vacancy;
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

    public int getVacancy() {
        return vacancy;
    }

    public void setVacancy(int vacancy) {
        this.vacancy = vacancy;
    }

    public String toString(){
        return name;
    }

    public void addStudent(Student s){
        this.students.add(s);
    }

    public void printStudent(){
        System.out.println("List of student in "+ this.toString());
        int index = 1;
        for(Student student:this.students){
            System.out.println(index + ". " + student.toString());
            index++;
        }
    }

    public void isAvaiable(){
        if (this.vacancy > this.students.size()){
            System.out.println("This slot now already has " + this.students.size() + "/" + this.vacancy);
        }else
            System.out.println("This slot is full " + this.students.size() + "/" + this.vacancy);
    }
}
