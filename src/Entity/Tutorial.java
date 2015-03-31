package Entity;

import java.util.ArrayList;

public class Tutorial extends CourseComponent implements java.io.Serializable {
	public Tutorial(String name) {
		super(name);
	}

	public Tutorial(String name, ArrayList<Student> student) {
		super(name, student);
	}
}

