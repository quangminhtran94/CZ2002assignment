package tutorial;
import java.util.ArrayList;

public class Tutorial implements java.io.Serializable {

	
		private int tutorialId;
		private String tutorialName;
		private ArrayList<Tutorial> tutorial;
		
		public Tutorial(String tutorialName, int tutorialId){
			this.tutorialId = tutorialId;
			this.tutorialName = tutorialName;
			
		}

	    public String getTutorialName(){
	    	
	    	return tutorialName;
	    }
	    
	    public void setTutorialName(String tutorialName){
	    	
	    	this.tutorialName = tutorialName;
	    }
	 
	    public int getTutorialId(){
	    	
	    	return tutorialId;
	    }
	    
	    public void setTutorialId(int tutorialId){
	    	
	    	this.tutorialId = tutorialId;
	    	
	    }
	}

