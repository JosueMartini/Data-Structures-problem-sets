public class UAHourlyEmployee extends UAEmployee {
	
	private float wage;
	private int numHoursWorked;
	
	public float getWage() {
		
		return this.wage;
		
	}
	
	public void setWage( float wage ) {
		
		this.wage = wage;
		
	}
	
	public int getNumHoursWorked() {
		
		return this.numHoursWorked;
		
	}
	
	public void setNumHoursWorked( int numHoursWorked ) {
		
		this.numHoursWorked = numHoursWorked;
		
	}

	public double calcWage() {

		return wage * numHoursWorked;

	}

	public String toString() {
		
		return "UAHourlyEmployee - Name: " + this.getFirstName() + " " + this.getLastName() + ", " + "EmpId: " + this.getEmployeeId() + ", " + "Dept: " + this.getDepartment() + ", " + "Wages: " + calcWage();

	}
	
	public UAHourlyEmployee() {
		
		super("","",0,"");
		
	}

}
