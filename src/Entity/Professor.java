package Entity;

/**
 * Created by quangminhtran94 on 4/16/15.
 */
public class Professor {
    /**
     * Professor id
     */
    int id;

    /**
     * professor name
     */
    String name;

    /**
     * course that professor is coordinator
     */
    Course course;

    public String getName(){
        return this.name;
    }

    public Professor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * set the course for prof to coordinate
     * @param c course
     */
    public void setCourse(Course c){
        this.course = c;
    }
}
