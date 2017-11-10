class Programmer extends Employee {
	protected double hoursWorked;
	protected double rateOfPay;

	public Programmer() {
	}

	public Programmer(String name, Date startDate, Date dateOfBirth, double weeklyPayAmount, double weeklyTaxAmount,
			double hoursWorked, double rateOfPay) {
		super(name, startDate, dateOfBirth, weeklyPayAmount, weeklyTaxAmount);
		this.hoursWorked = hoursWorked;
		this.rateOfPay = rateOfPay;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public double getTateOfPay() {
		return rateOfPay;
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public void setTateOfPay(double rateOfPay) {
		this.rateOfPay = rateOfPay;
	}

	@Override
	public void calcWeeklyPayAmount() {
		if (hoursWorked < 40)
			this.weeklyPayAmount = this.hoursWorked * this.rateOfPay;
		else
			this.weeklyPayAmount = ((this.hoursWorked - 40) * 1.5 + 40) * this.rateOfPay;
	}

}
