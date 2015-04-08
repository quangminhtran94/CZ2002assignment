package Entity;
import java.util.ArrayList;

public class Lab extends CourseComponent implements java.io.Serializable {
	public Lab(String name, Course course) {
		super(name, course);
	}

	public Lab(String name, ArrayList<Student> student) {
		super(name, student);
	}
}
