package Control;

import Entity.Course;
import Entity.Student;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Control class for courses
 */
public class CourseManager {


    public CourseManager(){

    }

    /**
     * Create a course
     * @param c the course want to create
     */
    public void create(Course c){
        c.create();
        System.out.print("\n\n");
    }

    /**
     * Add student s to course c
     * @param c course
     * @param s student
     */
    public void addStudent(Course c, Student s){
        c.addStudent(s);
        s.addCourse(c);
        System.out.print("\n\n");
    }


    /**
     * enter coursework marks for course c
     * @param c course
     */
    public void enterCourseMark(Course c){
        c.enterCourseMark();
        System.out.print("\n\n");
    }

    /**
     * enter exam mark for course c
     * @param c course
     */
    public void enterExamMark(Course c){
        c.enterExamMark();
        System.out.print("\n\n");
    }

    /**
     * print statistic for course c
     * @param c course
     */
    public void printStatistic(Course c){
        c.printStatistic();
        System.out.print("\n\n");
    }

    /**
     * print student list by course component of course c
     * @param c course
     */
    public void printStudentListByGroup(Course c){
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to print accordingly to [lecture/tutorial/lab]: ");
        c.printStudentListByGroup(input.nextLine());
        System.out.print("\n\n");
    }

    /**
     * print courses list
     * @param courses the list of courses
     */
    public void printCoursesList(ArrayList<Course> courses){
        for (int i = 0; i < courses.size(); i++)
            System.out.println((i+1) +". " + courses.get(i).toString());
        System.out.print("\n\n");
    }

    /**
     * check vacancy of course
     * @param course course
     */
    public void isVacancy(Course course){
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to check which kind of slot [lecture/tutorial/lab]: ");
        course.isVacancy(input.nextLine());
        System.out.print("\n\n");
    }
}
