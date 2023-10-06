public class UASalaryEmployee extends UAEmployee {
	
	private double monthlySalary;
	
	public double getMonthlySalary() {
		
		return this.monthlySalary;
		
	}
	
	public void setMonthlySalary( double monthlySalary ) {
		
		this.monthlySalary = monthlySalary;
		
	}
	
	public double calcWage() {

		return monthlySalary;
		
	}
	
	public String toString() {
		
		return "UASalaryEmployee - Name: " + this.getFirstName() + " " + this.getLastName() + ", " + "EmpId: " + this.getEmployeeId() + ", " + "Dept: " + this.getDepartment() + ", " + "Wages: " + calcWage();
		
	}
	
	public UASalaryEmployee() {
		
		super("","",0,"");
		
	}
	
//	public UASalaryEmployee( String y ) {
//		
//		
//		
//		
//	}
	
	

}
