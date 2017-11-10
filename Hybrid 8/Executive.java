class Executive extends Employee {
	protected double yearlySalary;

	public Executive() {
	}

	public Executive(String name, Date startDate, Date dateOfBirth, double weeklyPayAmount, double weeklyTaxAmount,
			double yearlySalary) {
		super(name, startDate, dateOfBirth, weeklyPayAmount, weeklyTaxAmount);
		this.yearlySalary = yearlySalary;
	}

	public double getYearlySalary() {
		return yearlySalary;
	}

	public void setYearlySalary(double yearlySalary) {
		this.yearlySalary = yearlySalary;
	}

	@Override
	public void calcWeeklyPayAmount() {
		this.weeklyPayAmount = yearlySalary / 52.0;
	}

}
