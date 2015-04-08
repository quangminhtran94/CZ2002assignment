package Entity;

import java.util.ArrayList;

public class Tutorial extends CourseComponent implements java.io.Serializable {
	public Tutorial(String name, Course course) {
		super(name, course);
	}

	public Tutorial(String name, ArrayList<Student> student) {
		super(name, student);
	}
}

