package adapter;

import model.Automotive;

/** 
* @author Hung Quach
*/
public abstract class ProxyAutomotive 
{	
	protected Automotive a1;
	
	public abstract Automotive buildAuto(String fileName);
	public abstract void modifyNameAndBasePrice(String modelName, int basePrice);
	public abstract void modifyOptionSet(String originalSetName, String newSetName);
	public abstract void modifyOption(String set, String opt, String name, int price);
	public abstract void print() ;
}
