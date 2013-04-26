package Model;

class Option { //Make the Option class an inner class of OptionSet (for Lab 1)
	private String name;
	private double baseprice;

	protected Option() { }
	
	protected Option(String name, double baseprice) {
		super();
		this.name = name;
		this.baseprice = baseprice;
	}
	
	protected Option(String name) {
		super();
		this.name = name;
	}
	
	protected Option(double baseprice) {
		super();
		this.baseprice = baseprice;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected double getBaseprice() {
		return baseprice;
	}

	protected void setBaseprice(double baseprice) {
		this.baseprice = baseprice;
	}
	
}
