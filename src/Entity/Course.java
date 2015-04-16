package Entity;
import Control.Utility;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;


public class Course {
	/**
	 * course id
	 */
	private int course_id;

	/**
	 * name of the course
	 */
	private String name;

	/**
	 * student list
	 */
	private ArrayList<Student> students;

	/**
	 * lecture list
	 */
	private ArrayList<Lecture> lectures;

	/**
	 * tutorial list
	 */
	private ArrayList<Tutorial> tutorials;

	/**
	 * lab list
	 */
	private ArrayList<Lab> labs;

	/**
	 * weight of final mark
	 */
	private int examWeight;

	/**
	 * coursework weights
	 */
	private ArrayList<Integer> courseWorkWeight;

	/**
	 * constructor Course()
	 */
	public Course(){
		this.students = new ArrayList<Student>();
		this.lectures = new ArrayList<Lecture>();
		this.tutorials = new ArrayList<Tutorial>();
		this.labs = new ArrayList<Lab>();
		this.courseWorkWeight = new ArrayList<Integer>();

	}

	/**
	 * overide the toString method, return name and id
	 * @return name and id
	 */
	public String toString(){
		return this.name + "with id = " + this.course_id;
	}

	/**
	 * return course id
	 * @return course id
	 */
	public int getCourse_id() {
		return course_id;
	}

	/**
	 * set course id
	 * @param course_id course id
	 */
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	/**
	 * return student list of this course
	 * @return student list
	 */
	public ArrayList<Student> getStudent() {
		return students;
	}

	/**
	 * set student list of this course
	 * @param students student list
	 */
	public void setStudent(ArrayList<Student> students) {
		this.students = students;
	}

	/**
	 * return course name
	 * @return course name
	 */
	public String getName() {
		return name;
	}

	/**
	 * set course name
	 * @param name desired name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get lecture list of this course
	 * @return lectures list
	 */
	public ArrayList<Lecture> getLecture() {
		return lectures;
	}

	/**
	 * set lecture list of this course
	 * @param lectures lectures list
	 */
	public void setLecture(ArrayList<Lecture> lectures) {
		this.lectures = lectures;
	}

	/**
	 * get tuorial list of this course
	 * @return tutorials list
	 */
	public ArrayList<Tutorial> getTutorial() {
		return tutorials;
	}

	/**
	 * set tutorial list of this course
	 * @param tutorials desired tutorial lists
	 */
	public void setTutorial(ArrayList<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}

	/**
	 * get lab list of this course
	 * @return desired lab lists
	 */
	public ArrayList<Lab> getLab() {
		return labs;
	}

	/**
	 * set lab list of this course
	 * @param labs lab list
	 */
	public void setLab(ArrayList<Lab> labs) {
		this.labs = labs;
	}

	/**
	 * get weight of final mark
	 * @return final mark weight
	 */
	public int getExamWeight() {
		return examWeight;
	}

	/**
	 * set weight of final mark
	 * @param examWeight exam weight
	 */
	public void setExamWeight(int examWeight) {
		this.examWeight = examWeight;
	}

	/**
	 * get coursework weights of this course
	 * @return array of coursework weight
	 */
	public ArrayList<Integer> getCourseWorkWeight() {
		return courseWorkWeight;
	}

	/**
	 * set coursework weights of this course
	 * @param courseWorkWeight coursework weights
	 */
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

		System.out.print("Enter the vacancy of lecture slot: ");
		int vacancy = Utility.getIntervalInput(1,100);
		System.out.println("Enter lectures (end when enter exit): ");
		String name = input.nextLine();
		while(!name.equals("exit")){
			this.lectures.add(new Lecture(name, this, vacancy));
			name = input.next();
		}

		System.out.print("Enter the vacancy of tutorial slot: ");
		vacancy = Utility.getIntervalInput(1, 100);
		System.out.println("Enter tutorials (end when enter exit): ");
		name = input.next();
		while(!name.equals("exit")){
			this.tutorials.add(new Tutorial(name, this, vacancy));
			name = input.next();
		}

		System.out.print("Enter the vacancy of lab slot: ");
		vacancy = Utility.getIntervalInput(1, 100);
		System.out.println("Enter labs (end when enter exit): ");
		name = input.next();
		while(!name.equals("exit")){
			this.labs.add(new Lab(name, this, vacancy));
			name = input.next();
		}

		System.out.print("Enter exam mark weight: ");
		this.examWeight = Utility.getIntervalInput(1, 100);
		System.out.print("Enter courseworks weight (sum is 100): ");
		this.courseWorkWeight = Utility.getSumInput(100);

		System.out.println("Course created successfully!");
	}


	/**
	 * add student s to this course
	 * @param s student
	 */
	public void addStudent(Student s){
		int index;
		if (this.students.contains(s))
			System.out.println("This student has already added to this course!");
		else{
			if(!this.lectures.isEmpty()){
				System.out.println("Choose lectures slot: ");
				for(index = 0; index< lectures.size(); index++)
					System.out.print((index+1) + " " + lectures.get(index).getName() + "\n");
				Scanner input = new Scanner(System.in);
				index = Utility.getIntervalInput(1, lectures.size()) - 1;
				lectures.get(index).addStudent(s);
			}

			if(!this.tutorials.isEmpty()){
				System.out.println("Choose tutorials slot: ");
				for(index = 0; index< tutorials.size(); index++)
					System.out.print((index+1) + " " + tutorials.get(index).getName() + "\n");
				index = Utility.getIntervalInput(1, tutorials.size()) - 1;
				tutorials.get(index).addStudent(s);
			}

			if(!this.labs.isEmpty()){
				System.out.println("Choose labs slot: ");
				for(index = 0; index< labs.size(); index++)
					System.out.print((index + 1) + " " + labs.get(index).getName() + "\n");
				index = Utility.getIntervalInput(1, labs.size()) - 1;
				labs.get(index).addStudent(s);
			}

			this.students.add(s);
			System.out.println("Student " + s.getName() + " has been added to course " + this.getName() +" successfully");
		}			
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
		if (this.hasAnyStudent()){
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
		}else
			System.out.println("This course has no student!");

	}

	
	/**
	 * enter exam mark for students in this course
	 */
	public void enterExamMark(){
		if (this.hasAnyStudent()){
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
		}else
			System.out.println("This course has no student!");
	}
	
	/**
	 * print course statistic
	 */
	public void printStatistic(){
		if (this.hasAnyStudent()){
			int sumFinalMark = 0;
			int sumCourseWorkMark = 0;
			if(this.students.isEmpty()){
				System.out.println("This course has no student!!!");
				return;
			}
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
		}else
			System.out.println("This course has no student!");

	}


	/**
	 * print student by course component of this course
	 * @param type course component type
	 */
	public void printStudentListByGroup(String type){
		if (this.hasAnyStudent()){
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
		}else
			System.out.println("This course has no student!");

	}

	/**
	 * check vacancy of *type* [lecture/tutorial/lab]
	 * @param type course component type
	 */
	public void isVacancy(String type){
		if (this.hasAnyStudent()){
			int choice;
			Scanner input = new Scanner(System.in);
			while(true){
				if(type.equals("lecture")){
					if(!this.lectures.isEmpty()){
						for(int index = 0; index< lectures.size(); index++)
							System.out.print((index+1) + " " + lectures.get(index).getName() + "\n");
						choice = Utility.getIntervalInput(1, lectures.size()) - 1;
						this.lectures.get(choice).isAvailable();
					}else{
						System.out.println("This course does not have any lecture slot");
					}

					break;
				}else if(type.equals("tutorial")){
					if(!this.tutorials.isEmpty()){
						for(int index = 0; index< tutorials.size(); index++)
							System.out.print((index+1) + " " + tutorials.get(index).getName() + "\n");
						choice = Utility.getIntervalInput(1, tutorials.size()) - 1;
						this.tutorials.get(choice).isAvailable();
					}else {
						System.out.println("This course does not have any tutorial slot");
					}
					break;
				}else if(type.equals("lab")){
					if(!this.labs.isEmpty()){
						for(int index = 0; index< labs.size(); index++)
							System.out.print((index+1) + " " + labs.get(index).getName() + "\n");
						choice = Utility.getIntervalInput(1, labs.size()) - 1;
						this.labs.get(choice).isAvailable();
					}else{
						System.out.println("This course does not have any lab slot");
					}

					break;
				}else{
					System.out.print("Please enter valid input [lecture/tutorial/lab]: ");
					type = input.nextLine();
				}
			}
		}else
			System.out.println("This course has no student!");
	}

	/**
	 * check if this course has any student
	 * @return if this course has any student
	 */
	private boolean hasAnyStudent(){
		if (this.students.isEmpty())
			return false;
		else
			return true;
	}
}
