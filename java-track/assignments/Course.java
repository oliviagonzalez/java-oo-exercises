
public class Course {
	
	private String courseName;
	private	int seats;
	private int credits;
	private Student[] studentArray;
	
	public Course(String course, int credits, int seats){
		this.courseName = course;
		this.credits = credits;
		this.seats = seats;
		this.studentArray = new Student[seats];
	}
	
	public String getName(){
		return this.courseName;
	}
	
	public int getRemainingSeats(){
		return this.seats;
	}
	
	public boolean addStudent(Student student){
		if(this.seats > 0){
			this.seats = this.seats - 1;
			for(int i = 0; i<studentArray.length; i++) {
			    if(studentArray[i] == null)
			    {
			        studentArray[i] = student;
			        break;
			    }
			}
			return true;
		}
		
		return false;
	}
	
	public double averageGPA(){
		double gpaTotal = 0;
		int studentCount = 0;
		if(studentArray[0]== null){
			return 0;
		}		
		for(int j = 0; j < studentArray.length; j++){
			if(studentArray[j] != null){
				gpaTotal += studentArray[j].getGPA();
				studentCount+= 1;
			}
		}
		return gpaTotal/studentCount;
	}
	
	public String toString(){
		return "Course Name:"+this.courseName+" Credits:" + this.credits;
	}
}
