package Entity;
import java.util.ArrayList;
import java.util.Scanner;


public class Course {

	private int course_id;
	private ArrayList<Student> student;
	private String name;
	private int vacancy;
	private ArrayList<Lecture> lecture;
	private ArrayList<Tutorial> tutorial;
	private ArrayList<Lab> lab;
	private int examWeight;
	private int[] courseWorkWeight;
	
	public Course(int course_id, ArrayList<Student> student, String name,
			int vacancy, ArrayList<Lecture> lecture,
			ArrayList<Tutorial> tutorial, ArrayList<Lab> lab, int examWeight,
			int[] courseWorkWeight) {
		super();
		this.course_id = course_id;
		this.student = student;
		this.name = name;
		this.vacancy = vacancy;
		this.lecture = lecture;
		this.tutorial = tutorial;
		this.lab = lab;
		this.examWeight = examWeight;
		this.courseWorkWeight = courseWorkWeight;
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
		return student;
	}
	public void setStudent(ArrayList<Student> student) {
		this.student = student;
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
		return lecture;
	}
	public void setLecture(ArrayList<Lecture> lecture) {
		this.lecture = lecture;
	}
	public ArrayList<Tutorial> getTutorial() {
		return tutorial;
	}
	public void setTutorial(ArrayList<Tutorial> tutorial) {
		this.tutorial = tutorial;
	}
	public ArrayList<Lab> getLab() {
		return lab;
	}
	public void setLab(ArrayList<Lab> lab) {
		this.lab = lab;
	}
	
	public int getExamWeight() {
		return examWeight;
	}

	public void setExamWeight(int examWeight) {
		this.examWeight = examWeight;
	}

	public int[] getCourseWorkWeight() {
		return courseWorkWeight;
	}

	public void setCourseWorkWeight(int[] courseWorkWeight) {
		this.courseWorkWeight = courseWorkWeight;
	}
	
	/**
	 * Add a student to a course, requiring to enter lecture, tutorial and lab slot.
	 */
	public void addStudent(Student s){
		int index;
		if (this.student.contains(s))
			System.out.println("This student has already added to this course!");
		else{
			System.out.println("Choose lecture slot: ");
			for(index = 0; index< lecture.size(); index++)
				System.out.print(index + " " + lecture.get(index).getName());
			Scanner input = new Scanner(System.in);
			index = input.nextInt();
			lecture.get(index).addStudent(s);
			
			System.out.println("Choose tutorial slot: ");
			for(index = 0; index< tutorial.size(); index++)
				System.out.print(index + " " + tutorial.get(index).getName());
			index = input.nextInt();
			tutorial.get(index).addStudent(s);
			
			System.out.println("Choose lab slot: ");
			for(index = 0; index< lab.size(); index++)
				System.out.print(index + " " + lab.get(index).getName());
			index = input.nextInt();
			lab.get(index).addStudent(s);
			
			this.student.add(s);
			this.vacancy--;
			s.addCourse(this);
		}			
	}
	
	public boolean isVacancy(){
		if (this.vacancy <= 0)
			return false;
		else
			return true;
	}
	
	/**
	 * enter course mark for students in this course
	 */
	public void enterCourseMark(){
		
	}
	
	
	/**
	 * enter exam mark for students in this course
	 */
	public void enterExamMark(){
		
	}
	
	/**
	 * print course statistic
	 */
	public void printStatistic(){
		
	}

	/**
	 * print students list in lecture, lab or tutorial group
	 * here I suppose there lecture, lab and tutorial implements 1 interface called Slot
	 */
	public void printStudentListByGroup(Slot s){
		s.printStudent();
	}
}
