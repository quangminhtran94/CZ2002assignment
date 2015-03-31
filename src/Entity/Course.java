package Entity;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;


public class Course {

	private int course_id;
	private String name;
	private int vacancy;
	private ArrayList<Student> student;
	private ArrayList<Lecture> lecture;
	private ArrayList<Tutorial> tutorial;
	private ArrayList<Lab> lab;
	private int examWeight;
	private ArrayList<Integer> courseWorkWeight;

	public Course(){
		this.student = new ArrayList<Student>();
		this.lecture = new ArrayList<Lecture>();
		this.tutorial = new ArrayList<Tutorial>();
		this.lab = new ArrayList<Lab>();
		this.courseWorkWeight = new ArrayList<Integer>();

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
		this.course_id = input.nextInt();
		System.out.println("Enter course name: ");
		this.name = input.next();
		System.out.println("Enter course vacancy: ");
		this.vacancy = input.nextInt();

		System.out.println("Enter lectures (end when enter exit): ");
		String name = input.next();
		while(!name.equals("exit")){
			this.lecture.add(new Lecture(name));
			name = input.next();
		}

		System.out.println("Enter tutorial (end when enter exit): ");
		name = input.next();
		while(!name.equals("exit")){
			this.tutorial.add(new Tutorial(name));
			name = input.next();
		}

		System.out.println("Enter lab (end when enter exit): ");
		name = input.next();
		while(!name.equals("exit")){
			this.lab.add(new Lab(name));
			name = input.next();
		}

		System.out.print("Enter exam mark weight: ");
		this.examWeight = input.nextInt();

		System.out.print("Enter courseworks weight end with -1: ");
		int weight = input.nextInt();
		while(weight != -1){
			this.courseWorkWeight.add(weight);
			weight = input.nextInt();
		}

		System.out.println("Course created successfully!");
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
	 * here I suppose there lecture, lab and tutorial implements 1 interface called CourseComponent
	 */
	public void printStudentListByGroup(CourseComponent component){
		component.printStudent();
	}
}
