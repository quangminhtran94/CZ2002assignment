package Entity;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by quangminhtran94 on 4/4/15.
 */
public class Record {
    private Student student;
    private Course course;
    private int finalMark;
    private ArrayList<Integer> courseworkMark;
    private double aveCourseWork;
    private double aveTotal;

    /**
     * Constructor
     * @param student
     * @param course
     */
    public Record(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.courseworkMark =  new ArrayList<Integer>();
        this.aveCourseWork = 0;
        this.aveTotal=0;
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

    public double getAveCourseWork() {
        return aveCourseWork;
    }

    public void setAveCourseWork(double aveCourseWork) {
        this.aveCourseWork = aveCourseWork;
    }

    public double getAveTotal() {
        return aveTotal;
    }

    public void setAveTotal(double aveTotal) {
        this.aveTotal = aveTotal;
    }

    /**
     * calculate average mark
     */
    public void calculateAverage(){
        this.aveCourseWork = 0;
        this.aveTotal = 0;
        for(int i = 0; i < this.courseworkMark.size(); i++)
            this.aveCourseWork += this.courseworkMark.get(i) * this.course.getCourseWorkWeight().get(i) /100;
        this.aveTotal = this.aveCourseWork * (100 - this.course.getExamWeight()) / 100 + this.finalMark * this.course.getExamWeight() / 100;
    }

    /**
     * print the record
     */
    public void print(){
        System.out.println("Course:     " + this.course.toString());
        System.out.println("Exam mark:      " + this.finalMark);
        System.out.println("Coursework marks:       " + this.courseworkMark.toString());
        System.out.println("Average Coursework marks:       " + this.aveCourseWork);
        System.out.println("Average Total mark:     " + this.aveTotal);
        System.out.println();
    }
}
