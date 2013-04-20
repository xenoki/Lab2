package Model;

public class Automotive {
	
	private String name;
	private double baseprice;
	OptionSet opSet [];
	
	public Automotive() { }
	
	public Automotive(String name, double baseprice) {
		super();
		this.name = name;
		this.baseprice = baseprice;
		opSet = new OptionSet[5];
		opSet[0] = new OptionSet(); //write a loop for this.
	}
	
	public Automotive(String name) {
		super();
		this.name = name;
	}
	
	public Automotive(double baseprice) {
		super();
		this.baseprice = baseprice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBaseprice() {
		return baseprice;
	}

	public void setBaseprice(double baseprice) {
		this.baseprice = baseprice;
	}
	
	
}
