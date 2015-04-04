package Entity;

import java.util.ArrayList;

/**
 * Created by quangminhtran94 on 4/4/15.
 */
public class Record {
    private Student student;
    private Course course;
    private int finalMark;
    private ArrayList<Integer> courseworkMark;

    /**
     * Constructor
     * @param student
     * @param course
     */
    public Record(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.courseworkMark =  new ArrayList<Integer>();
    }

    /**
     * getter and setter
     */
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(int finalMark) {
        this.finalMark = finalMark;
    }

    public ArrayList<Integer> getCourseworkMark() {
        return courseworkMark;
    }

    public void setCourseworkMark(ArrayList<Integer> courseworkMark) {
        this.courseworkMark = courseworkMark;
    }
}
