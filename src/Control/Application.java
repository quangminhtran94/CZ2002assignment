package Control;

import Entity.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by quangminhtran94 on 3/31/15.
 */

/**
 * TODO: fulfill requirements, adding catch exception, adding flat file storage
 */

/**
 * Requirement
 * 1. Add a student (done)
 * 2. Add a course (done)
 * 3. Register student for a course (this include registering for Tutorial/Lab classes) (done)
 * 4. Check available slot in a class (vacancy in a class) (done)
 * 5. Print student list by lecture, tutorial or laboratory session for a course. (done, not test)
 * 6. Enter course assessment components weightage (done, when adding a course)
 * 7. Enter coursework mark – inclusive of its components. (done)
 * 8. Enter exam mark (done)
 * 9. Print course statistics (done)
 * 10. Print student transcript. (done)
 */

public class Application {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Course> courses = new ArrayList<Course>();
        CourseManager courseMng = new CourseManager();
        StudentManager studentMng = new StudentManager();
        Course tempCourse;
        Student tempStudent;
        int choice = 0;
        int noStudent, noCourse;
        Scanner input = new Scanner(System.in);


        printMenu();
        choice = Utility.getIntervalInput(1,10);
        while (choice < 10){
            switch(choice){
                case 1:
                    tempCourse = new Course();
                    courseMng.create(tempCourse);
                    courses.add(tempCourse);
                    break;
                case 2:
                    tempStudent = new Student();
                    studentMng.create(tempStudent);
                    students.add(tempStudent);
                    break;
                case 3:
                    System.out.println("Enter the number of student you want to add (not the id): ");
                    studentMng.printStudentsList(students);
                    noStudent = Utility.getIntervalInput(1, students.size()) - 1;
                    System.out.println("Enter the number of course you want to add choosen student (not the id): ");
                    courseMng.printCoursesList(courses);
                    noCourse = Utility.getIntervalInput(1, courses.size()) - 1;
                    courseMng.addStudent(courses.get(noCourse), students.get(noStudent));
                    break;
                case 4:
                    System.out.println("Enter the number of course you want to check vacancy (not the id): ");
                    courseMng.printCoursesList(courses);
                    noCourse = Utility.getIntervalInput(1, courses.size()) - 1;
                    courseMng.checkVacancy(courses.get(noCourse));
                    break;
                case 5:
                    System.out.println("Enter the number of course you want to print students list (not the id): ");
                    courseMng.printCoursesList(courses);
                    noCourse = Utility.getIntervalInput(1, courses.size()) - 1;
                    courseMng.printStudentListByGroup(courses.get(noCourse));
                    break;
                case 6:
                    System.out.println("Enter the number of course you want to enter coursework marks (not the id): ");
                    courseMng.printCoursesList(courses);
                    noCourse = Utility.getIntervalInput(1, courses.size()) - 1;
                    courseMng.enterCourseMark(courses.get(noCourse));
                    break;
                case 7:
                    System.out.println("Enter the number of course you want to enter final marks (not the id): ");
                    courseMng.printCoursesList(courses);
                    noCourse = Utility.getIntervalInput(1, courses.size())- 1;
                    courseMng.enterExamMark(courses.get(noCourse));
                    break;
                case 8:
                    System.out.println("Enter the number of course you want to print statistic (not the id): ");
                    courseMng.printCoursesList(courses);
                    noCourse = Utility.getIntervalInput(1, courses.size()) - 1;
                    courseMng.printStatistic(courses.get(noCourse));
                    break;
                case 9:
                    System.out.println("Enter the number of student you want to print transcript (not the id): ");
                    studentMng.printStudentsList(students);
                    noStudent = Utility.getIntervalInput(1, students.size()) - 1;
                    students.get(noStudent).printTranscript();
                    break;
                default:
                    System.out.println("Program terminating....");
                    break;
            }
            printMenu();
            choice = Utility.getIntInput();
        }
    }


    private static void printMenu(){
        System.out.println("1. Add a course");
        System.out.println("2. Add a student");
        System.out.println("3. Add a student to a course");
        System.out.println("4. Check vacancy of a course");
        System.out.println("5. Print student of a course");
        System.out.println("6. Enter students coursework mark");
        System.out.println("7. Enter students final mark");
        System.out.println("8. Print a course statistic");
        System.out.println("9. Print a student transcript");
        System.out.println("10. Exit");

        System.out.print("Enter your choice: ");
    }
}
