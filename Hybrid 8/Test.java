class Test {
	public static void main(String[] args) {
		Employee[] company = new Employee[4];
		Date today = new Date(2010, 2, 2);
		Date dob = new Date(1977, 5, 4);

		company[0] = new Employee("Joe Blow", today, dob, 100.0, 0.0);
		dob = new Date(1960, 12, 5);
		company[1] = new Executive("Bob Gillet", today, dob, 0.0, 0.0, 260000.0);
		dob = new Date(1950, 12, 12);
		company[2] = new SalesRep("Sue Smith", today, dob, 0.0, 0.0, 10000.0, 0.10);
		dob = new Date(1970, 1, 5);
		company[3] = new Programmer("you", today, dob, 0.0, 0.0, 42.5, 100.0);

		for (int i = 0; i < 4; i++) {
			company[i].calcWeeklyPayAmount();
			company[i].calcWeeklyTaxAmount();
			System.out.println(company[i]);
			System.out.println();
		}
	}

}
