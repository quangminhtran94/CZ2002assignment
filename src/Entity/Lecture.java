package lecture;
import java.util.ArrayList;
public class Lecture implements java.io.Serializable {

	private String lecture;
	private String lectureName;
	
	public Lecture(String lecture){
		this.lecture = lecture;
		
	}

   
    public String getName(){
    	
    	return lecture;
    }
    
    public void setName(String lecture){
    	
    	this.lecture = lecture;
    	
    }
}
