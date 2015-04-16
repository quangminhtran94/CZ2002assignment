package Entity;

import java.util.ArrayList;

public class Tutorial extends CourseComponent implements java.io.Serializable {
	public Tutorial(String name, Course course, int vacancy) {
		super(name, course, vacancy);
	}

	public Tutorial(String name, ArrayList<Student> student) {
		super(name, student);
	}
}

