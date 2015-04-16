package Entity;

import java.util.ArrayList;

/**
 * Including lecture lab and tutorial
 */
public class CourseComponent {
    /**
     * name of this component
     */
    private String name;

    /**
     * course that this component belongs to
     */
    Course course;

    /**
     * student list in this component
     */
    ArrayList<Student> students;

    /**
     * vacancy of this component
     */
    int vacancy;

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
     * get name of this component
     * @return name of this component
     */
    public String getName() {
        return name;
    }

    /**
     * get course of this component
     * @return course of this component
     */
    public Course getCourse() {
        return course;
    }

    /**
     * set course of this component
     * @param course course
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * get student list in this component
     * @return student list
     */
    public ArrayList<Student> getStudent() {
        return students;
    }

    /**
     * set student list of this component
     * @param student student
     */
    public void setStudent(ArrayList<Student> student) {
        this.students = student;
    }

    /**
     * set the name of this component
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get vacancy number
     * @return vacancy number
     */
    public int getVacancy() {
        return vacancy;
    }

    /**
     * set vacancy number
     * @param vacancy vacancy
     */
    public void setVacancy(int vacancy) {
        this.vacancy = vacancy;
    }

    /**
     * overide toString(), return name
     * @return return name
     */
    public String toString(){
        return name;
    }

    /**
     * add a student s to this component
     * @param s student
     */
    public void addStudent(Student s){
        this.students.add(s);
    }

    /**
     * print student list of this component
     */
    public void printStudent(){
        System.out.println("List of student in "+ this.toString());
        int index = 1;
        for(Student student:this.students){
            System.out.println(index + ". " + student.toString());
            index++;
        }
    }

    /**
     * check if this component has any available slot and print notification
     */
    public void isAvailable(){
        if (this.vacancy > this.students.size()){
            System.out.println("This slot now already has " + this.students.size() + "/" + this.vacancy);
        }else
            System.out.println("This slot is full " + this.students.size() + "/" + this.vacancy);
    }
}
