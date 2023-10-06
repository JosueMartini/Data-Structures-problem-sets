public class UACommissionEmployee extends UAEmployee {
	
	private float commissionRate;
	private float grossSales;
	
	public float getCommissionRate() {
		
		return this.commissionRate;
		
	}
	
	public void setCommissionRate( float commissionRate ) {
		
		this.commissionRate = commissionRate;
		
	}
	
	public float getGrossSales() {
		
		return this.grossSales;
		
	}
	
	public void setGrossSales( float grossSales ) {
		
		this.grossSales = grossSales;
		
	}

	public double calcWage() {

		return grossSales * commissionRate;

	}

	public String toString() {
		
		return "UACommissionEmployee - Name: " + this.getFirstName() + " " + this.getLastName() + ", " + "EmpId: " + this.getEmployeeId() + ", " + "Dept: " + this.getDepartment() + ", " + "Wages: " + calcWage();

	}
	
	public UACommissionEmployee() {
		
		super("","",0,"");

	}

}
