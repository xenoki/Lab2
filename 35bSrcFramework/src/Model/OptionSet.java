package Model;

 class OptionSet {
	private String name;
	protected Option opt[];
	protected OptionSet() //Add constructors with name and opt input. default constructor
	{
		opt = new Option[5];
		for(int i = 0;i<opt.length;i++)
		{
			opt[i] = new Option();
		}
	}
	protected OptionSet(String name, int size) //Add constructors with name and opt input. default constructor
	{
		this.name = name;
		opt = new Option[size];
		for(int i = 0;i<opt.length;i++)
		{
			opt[i] = new Option();
		}
	}
	//Add getter and setter for all instance variables.
	//Add print method and a tostring method that is nicely formatted.
	/*  getName(): String
	 setName(s: String): void
	 getOptions(): Option[]
	 setOptions(options: Option[]): void
	 setOption(int i, String name, int price): void
	 getOption(name: String): Option
	 getOptionPrice(name: String): int
	 findOption(name: String): int */ 

}
