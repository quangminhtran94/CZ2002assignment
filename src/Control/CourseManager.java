package Control;

import Entity.Course;
import Entity.Student;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by quangminhtran94 on 4/15/15.
 */
public class CourseManager {


    public CourseManager(){

    }


    public void create(Course c){
        c.create();
        System.out.print("\n\n");
    }

    public void addStudent(Course c, Student s){
        c.addStudent(s);
        System.out.print("\n\n");
    }



    public void enterCourseMark(Course c){
        c.enterCourseMark();
        System.out.print("\n\n");
    }

    public void enterExamMark(Course c){
        c.enterExamMark();
        System.out.print("\n\n");
    }

    public void printStatistic(Course c){
        c.printStatistic();
        System.out.print("\n\n");
    }

    public void printStudentListByGroup(Course c){
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to print accordingly to [lecture/tutorial/lab]: ");
        c.printStudentListByGroup(input.nextLine());
        System.out.print("\n\n");
    }

    public void printCoursesList(ArrayList<Course> courses){
        for (int i = 0; i < courses.size(); i++)
            System.out.println((i+1) +". " + courses.get(i).toString());
        System.out.print("\n\n");
    }

    public void isVacancy(Course course){
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to check which kind of slot [lecture/tutorial/lab]: ");
        course.isVacancy(input.nextLine());
        System.out.print("\n\n");
    }
}
