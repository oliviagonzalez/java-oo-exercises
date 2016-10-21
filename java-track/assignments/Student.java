public class Student {

	private String firstName;
	private String lastName;
	private Integer studentId;
	private Integer credits = 0;
	private Double gpa = 0.0;
	private Double quality = 0.0;
	
	
	
	public Student(String firstName, String lastName, Integer studentId){
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentId = studentId;
	}
	
	public String getName(){
		return this.firstName + " " + this.lastName;
	}
	
	public double getGPA(){
		return Math.round(1000.0 * this.gpa)/ 1000.0;
	}
	
	public int getStudentID(){
		return this.studentId;
	}
	
	public int getCredits(){
		return this.credits;
	}
	
	public String getClassStanding(){
		if(this.credits < 30){
			return "Freshman";
		}
		else if(this.credits < 60){
			return "Sophomore";
		}
		else if(this.credits < 90){
			return "Junior";
		}
		else if(this.credits >= 90){
			return "Senior";
		}
		else{
			return "Error";
		}
	}
	
	public double submitGrade(double grade, int credits){
		this.quality = this.quality + grade*credits;
		this.gpa = quality/(this.credits + credits);	
		this.credits = this.credits + credits;
		return this.gpa;
	}
	
	public double computeTuition(){
		int fifteenCredits = this.credits/15;		
		return this.credits%15*1333.33 + 20000*fifteenCredits;
	}
	
	public Student createLegacy(Student student1, Student student2){
		Student legacy = new Student(student1.getName(), student2.getName(), student1.studentId+student2.studentId);
		double legacyGPA = (student1.getGPA()+student2.getGPA())/2.000;
		int legacyCredits = Math.max(student1.getCredits(), student2.getCredits());
		legacy.submitGrade(legacyGPA, legacyCredits);
		return legacy;
	}

	public String toString(){
		return "Name:"+ this.getName() + " Student ID:" + this.studentId;
	}
}
