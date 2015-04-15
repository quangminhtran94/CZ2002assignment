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
    }

    public void addStudent(Course c, Student s){
        c.addStudent(s);
    }

    public void checkVacancy(Course c){
        if(c.isVacancy())
            System.out.println("This course has available vacancies");
        else
            System.out.println("This course has no vacancy!!");
    }

    public void enterCourseMark(Course c){
        c.enterCourseMark();
    }

    public void enterExamMark(Course c){
        c.enterExamMark();
    }

    public void printStatistic(Course c){
        c.printStatistic();
    }

    public void printStudentListByGroup(Course c){
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to print accordingly to [lecture/tutorial/lab]: ");
        c.printStudentListByGroup(input.nextLine());
    }

    public void printCoursesList(ArrayList<Course> courses){
        for (int i = 0; i < courses.size(); i++)
            System.out.println((i+1) +". " + courses.get(i).toString());
    }

}
