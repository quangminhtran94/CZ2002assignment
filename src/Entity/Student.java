package Entity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private int id;
    private String name;
    private ArrayList<Course> courses;
    private ArrayList<Record> records;

    public String toString(){
        return this.name + " with id " + this.id;
    }

    /**
     * getter and setter
     */

    public ArrayList<Record> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<Record> records) {
        this.records = records;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    /**
     * Constructors
     */
    public Student(){
        this.courses = new ArrayList<Course>();
        this.records = new ArrayList<Record>();
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.courses = new ArrayList<Course>();
        this.records = new ArrayList<Record>();
    }

    /**
     * Create a new student
     */
    public void create(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter student Id: ");
        this.id = input.nextInt();
        System.out.println("Enter student name: ");
        this.name = input.next();
    }


    /**
     * Add a course for a student
     * @param c
     */
    public void addCourse(Course c){
        if (courses.contains(c)){
            System.out.println("This student has already taken this course");
        }else{
            this.courses.add(c);
            this.records.add(new Record(this, c));
        }
    }

    /**
     * calculate average mark for all records of this student
     */
    public void calculateAverage(){
        for(Record record:this.records)
            record.calculateAverage();
    }

    /**
     * Print statistic
     */
    public void printTranscript() {
        this.calculateAverage();
        System.out.println("Transcript of student " + this.toString());
        System.out.println();
        for(Record record:this.records)
            record.print();
        int aveGrade = 0;
        int aveCourseWork = 0;
        for(Record record:this.records){
            aveGrade += record.getAveTotal();
            aveCourseWork += record.getAveCourseWork();
        }
        aveGrade = aveGrade / this.records.size();
        aveCourseWork = aveCourseWork / this.records.size();
        System.out.println("Average Grade:      " + aveGrade);
        System.out.println("Average Courseworkmakr:     " + aveCourseWork);
        System.out.println();
    }


}
