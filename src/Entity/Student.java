package Entity;

import Control.Utility;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    /**
     * id of this student
     */
    private int id;

    /**
     * name of this student
     */
    private String name;

    /**
     * course list of this student
     */
    private ArrayList<Course> courses;

    /**
     * records list of this student
     */
    private ArrayList<Record> records;

    /**
     * override toString method, return name and id
     * @return name and id
     */
    public String toString(){
        return this.name + " with id " + this.id;
    }

    /**
     * get record list of this student
     * @return list of records
     */
    public ArrayList<Record> getRecords() {
        return records;
    }

    /**
     * set recored list of this student
     * @param records records
     */
    public void setRecords(ArrayList<Record> records) {
        this.records = records;
    }

    /**
     * get id of this student
     * @return id of this student
     */
    public int getId() {
        return id;
    }

    /**
     * set id of this student
     * @param id id of this student
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get name of this student
     * @return name of this student
     */
    public String getName() {
        return name;
    }

    /**
     * set name of this student
     * @param name name of this student
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * course list that this student take
     * @return course list
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * set course list of this student
     * @param courses courses this student take
     */
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }


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
     * create a new student
     */
    public void create(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter student Id: ");
        this.id = Utility.getIntervalInput(1, Integer.MAX_VALUE);
        System.out.println("Enter student name: ");
        this.name = input.nextLine();
    }


    /**
     * Add a course for a student
     * @param c course that student take
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
        System.out.println("Average Courseworkmark:     " + aveCourseWork);
        System.out.println();
    }


}
