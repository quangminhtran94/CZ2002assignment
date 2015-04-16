package Entity;
import java.util.ArrayList;

public class Lab extends CourseComponent implements java.io.Serializable {
	public Lab(String name, Course course, int vacancy) {
		super(name, course, vacancy);
	}

	public Lab(String name, ArrayList<Student> student) {
		super(name, student);
	}
}
