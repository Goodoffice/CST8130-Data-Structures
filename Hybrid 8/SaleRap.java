class SalesRep extends Employee {
	protected double salesAmount;
	protected double commissionRate;

	public SalesRep() {
	}

	public SalesRep(String name, Date startDate, Date dateOfBirth, double weeklyPayAmount, double weeklyTaxAmount,
			double salesAmount, double commissionRate) {
		super(name, startDate, dateOfBirth, weeklyPayAmount, weeklyTaxAmount);
		this.salesAmount = salesAmount;
		this.commissionRate = commissionRate;
	}

	public double getSalesAmount() {
		return salesAmount;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setSalesAmount(double salesAmount) {
		this.salesAmount = salesAmount;
	}

	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}

	@Override
	public void calcWeeklyPayAmount() {
		this.weeklyPayAmount = this.salesAmount * this.commissionRate;
	}

}
