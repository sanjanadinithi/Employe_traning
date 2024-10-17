package course_1;

public class Course_1 {
	
	private int cID;
	private String cname;
	private String cDuration;
	private String cInstructor;
	private String cDescription;
	private String cLink;
	
	public Course_1(int cID, String cname, String cDuration, String cInstructor, String cDescription, String cLink) {
		
		this.cID = cID;
		this.cname = cname;
		this.cDuration = cDuration;
		this.cInstructor = cInstructor;
		this.cDescription = cDescription;
		this.cLink = cLink;
	}
	
	  public Course_1(String cname, String cDescription) {
	        this.cname = cname;
	        this.cDescription = cDescription;
	        this.cID = 0;
	        this.cDuration = ""; 
	        this.cInstructor = ""; 
	        this.cLink = ""; 
	    }

	public int getcID() {
		return cID;
	}

	public String getCname() {
		return cname;
	}

	public String getcDuration() {
		return cDuration;
	}

	public String getcInstructor() {
		return cInstructor;
	}

	public String getcDescription() {
		return cDescription;
	}

	public String getcLink() {
		return cLink;
	}

}
