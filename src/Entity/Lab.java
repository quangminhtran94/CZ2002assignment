package lab;
import java.util.ArrayList;

public class Lab implements java.io.Serializable {

	private int labId;
	private String labName;
	private ArrayList<Lab> lab;
	

	public Lab(String labName, int labId){
		
		this.labId = labId;
		this.labName = labName;
		
	}
		 public String labName(){
		    	
		    	return labName;
		    }
		    
		    public void setLabName(String labName){
		    	
		    	this.labName = labName;
		    }
		 
		    public int getlabId(){
		    	
		    	return labId;
		    }
		    
		    public void setlabId(int labId){
		    	
		    	this.labId = labId;
		    	
		    }
		    
	

}
