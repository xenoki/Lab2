package adapter;

public interface UpdateAutomotive 
{
	public void modifyNameAndBasePrice(String modelName, int basePrice);
	public abstract void modifyOptionSet(String originalSetName, String newSetName);
	public abstract void modifyOption(String set, String opt, String name, int price);
}
