package adapter;

public interface AutomotiveAPI 
{
	public void readFile(String filename);
	public void modifyNameAndBasePrice(String modelName, int basePrice);
	public void modifyOptionSet(String originalSetName, String newSetName);
	public void modifyOption(String set, String opt, String name, int price);
	public void print();
}
