public class UABaseWithCommissionEmployee extends UACommissionEmployee {
	
	private double baseSalary;
	
	public double getBaseSalary() {
		
		return this.baseSalary;
		
	}
	
	public void setBaseSalary( double baseSalary ) {
		
		this.baseSalary = baseSalary;
		
	}
	
	public double calcWage() {

		return baseSalary + this.getCommissionRate() * this.getGrossSales();

	}

	public String toString() {
		
		return "UABaseWithCommissionEmployee - Name: " + this.getFirstName() + " " + this.getLastName() + ", " + "EmpId: " + this.getEmployeeId() + ", " + "Dept: " + this.getDepartment() + ", " + "Wages: " + calcWage();

	}
	
	public UABaseWithCommissionEmployee() {
		
		super();
		
	}

}
