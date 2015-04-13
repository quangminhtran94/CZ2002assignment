package Entity;
import Control.Utility;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;


public class Course {

	private int course_id;
	private String name;
	private int vacancy;
	private ArrayList<Student> students;
	private ArrayList<Lecture> lectures;
	private ArrayList<Tutorial> tutorials;
	private ArrayList<Lab> labs;
	private int examWeight;
	private ArrayList<Integer> courseWorkWeight;

	public Course(){
		this.students = new ArrayList<Student>();
		this.lectures = new ArrayList<Lecture>();
		this.tutorials = new ArrayList<Tutorial>();
		this.labs = new ArrayList<Lab>();
		this.courseWorkWeight = new ArrayList<Integer>();

	}

	public String toString(){
		return this.name;
	}
	
	/**
	 * getter and setter method
	 */
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public ArrayList<Student> getStudent() {
		return students;
	}
	public void setStudent(ArrayList<Student> students) {
		this.students = students;
	}
	public String getName() {
		return name;
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
	public ArrayList<Lecture> getLecture() {
		return lectures;
	}
	public void setLecture(ArrayList<Lecture> lectures) {
		this.lectures = lectures;
	}
	public ArrayList<Tutorial> getTutorial() {
		return tutorials;
	}
	public void setTutorial(ArrayList<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}
	public ArrayList<Lab> getLab() {
		return labs;
	}
	public void setLab(ArrayList<Lab> labs) {
		this.labs = labs;
	}
	
	public int getExamWeight() {
		return examWeight;
	}

	public void setExamWeight(int examWeight) {
		this.examWeight = examWeight;
	}

	public ArrayList<Integer> getCourseWorkWeight() {
		return courseWorkWeight;
	}

	public void setCourseWorkWeight(ArrayList<Integer> courseWorkWeight) {
		this.courseWorkWeight = courseWorkWeight;
	}


	/**
	 * create a course
	 */
	public void create(){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter course Id: ");
		this.course_id = Utility.getIntervalInput(1, Integer.MAX_VALUE);
		System.out.println("Enter course name: ");
		this.name = input.nextLine();
		System.out.println("Enter course vacancy: ");
		this.vacancy = Utility.getIntervalInput(1, Integer.MAX_VALUE);
		System.out.println("Enter lectures (end when enter exit): ");
		String name = input.nextLine();
		while(!name.equals("exit")){
			this.lectures.add(new Lecture(name, this));
			name = input.next();
		}

		System.out.println("Enter tutorials (end when enter exit): ");
		name = input.next();
		while(!name.equals("exit")){
			this.tutorials.add(new Tutorial(name, this));
			name = input.next();
		}

		System.out.println("Enter labs (end when enter exit): ");
		name = input.next();
		while(!name.equals("exit")){
			this.labs.add(new Lab(name, this));
			name = input.next();
		}

		System.out.print("Enter exam mark weight: ");
		this.examWeight = Utility.getIntervalInput(1, 100);
		System.out.print("Enter courseworks weight (sum is 100): ");
		this.courseWorkWeight = Utility.getSumInput(100);

		System.out.println("Course created successfully!");
	}

	
	/**
	 * Add a student to a course, requiring to enter lectures, tutorials and labs slot.
	 */
	public void addStudent(Student s){
		int index;
		if (this.students.contains(s))
			System.out.println("This student has already added to this course!");
		else{
			System.out.println("Choose lectures slot: ");
			for(index = 0; index< lectures.size(); index++)
				System.out.print((index+1) + " " + lectures.get(index).getName() + "\n");
			Scanner input = new Scanner(System.in);
			index = Utility.getIntervalInput(1, lectures.size()) - 1;
			lectures.get(index).addStudent(s);
			
			System.out.println("Choose tutorials slot: ");
			for(index = 0; index< tutorials.size(); index++)
				System.out.print((index+1) + " " + tutorials.get(index).getName() + "\n");
			index = Utility.getIntervalInput(1, tutorials.size()) - 1;
			tutorials.get(index).addStudent(s);
			
			System.out.println("Choose labs slot: ");
			for(index = 0; index< labs.size(); index++)
				System.out.print((index + 1) + " " + labs.get(index).getName() + "\n");
			index = Utility.getIntervalInput(1, labs.size()) - 1;
			labs.get(index).addStudent(s);
			
			this.students.add(s);
			this.vacancy--;
			s.addCourse(this);
			System.out.println("Student " + s.getName() + " has been added to course " + this.getName() +" successfully");
		}			
	}
	
	public boolean isVacancy(){
		if (this.vacancy <= 0)
			return false;
		else
			return true;
	}

	/**
	 * Print information of the course
	 */
	public void printInfo(){
		for (Field field : this.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			String name = field.getName();
			Object value = null;
			try {
				value = field.get(this);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			System.out.printf("Field name: %s, Field value: %s%n", name, value);
		}
	}

	/**
	 * enter course mark for students in this course
	 */
	/**
	 * TODO: add validator
	 */
	public void enterCourseMark(){
		Scanner input = new Scanner(System.in);
		System.out.print("There are " + this.courseWorkWeight.size() +" course marks required with weight of ");
		for(Integer weight : this.courseWorkWeight)
			System.out.print(weight * (100 - this.examWeight) / 100 + "% ");
		System.out.println("respectively, please enter all marks required in order:");
		for(Student student : this.students){
			System.out.print("Enter coursework marks for " + student.getName() + " with id " + student.getId() + ": ");
			ArrayList<Integer> marks = new ArrayList<Integer>();
			for (int i = 0; i < this.courseWorkWeight.size(); i++)
				marks.add(Utility.getIntervalInput(0, 100));
			for (Record record : student.getRecords()){
				if (record.getCourse().equals(this)){
					record.setCourseworkMark(marks);
					break;
				}else
					continue;
			}
		}
	}

	
	/**
	 * enter exam mark for students in this course
	 */
	public void enterExamMark(){
		Scanner input = new Scanner(System.in);
		for (Student student : this.students){
			System.out.print("Enter final exam mark for " + student.getName() + " with id " + student.getId() + ": ");
			int mark = Utility.getIntervalInput(0,100);
			for (Record record : student.getRecords()){
				if (record.getCourse().equals(this)){
					record.setFinalMark(mark);
					break;
				}else
					continue;
			}
		}
	}
	
	/**
	 * print course statistic
	 */
	public void printStatistic(){
		int sumFinalMark = 0;
		int sumCourseWorkMark = 0;
		for(Student student:this.students){
			for (Record record : student.getRecords()){
				if (record.getCourse().equals(this)){
					sumFinalMark += record.getFinalMark();
					for(int i = 0; i < this.courseWorkWeight.size(); i++) {
						sumCourseWorkMark += record.getCourseworkMark().get(i) * this.courseWorkWeight.get(i) / 100;
					}
					break;
				}else
					continue;
			}
		}
		int aveFinal = sumFinalMark/this.students.size();
		int aveCourseWork = sumCourseWorkMark/this.students.size();
		int aveTotal = aveFinal * this.examWeight / 100 + aveCourseWork * (100-this.examWeight) / 100;
		System.out.println("Average exam mark: " + aveFinal + " Average coursework mark: " + aveCourseWork
		+ " Average total mark " + aveTotal);
	}




	/**
	 * print students list in lectures, labs or tutorials group
	 * here I suppose there lectures, labs and tutorials implements 1 interface called CourseComponent
	 */
	public void printStudentListByGroup(String type)
	{
		Scanner input = new Scanner(System.in);
		while(true){
			if(type.equals("lecture")){
				for(Lecture lecture:this.lectures){
					lecture.printStudent();
				}
				break;
			}else if(type.equals("tutorial")){
				for(Tutorial tutorial:this.tutorials) {
					tutorial.printStudent();
				}
				break;
			}else if(type.equals("lab")){
				for(Lab lab:this.labs) {
					lab.printStudent();
				}
				break;
			}else{
				System.out.print("Please enter valid input [lecture/tutorial/lab]: ");
				type = input.nextLine();
			}
		}
	}
}
