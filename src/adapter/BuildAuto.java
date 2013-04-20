package adapter;

import model.Automotive;
import util.*;


public class BuildAuto implements AutomotiveAPI
{
	//private static final long serialVersionUID = -4807465514121630378L;
	
	private Automotive a1;
	
    public void readFile(String filename) 
	{
		a1 = new FileIO().readFile(filename);
	}

	public void modifyNameAndBasePrice(String modelName, int basePrice) 
	{
		a1.updateModelNameAndPrice(modelName, basePrice);
	}

	public void modifyOptionSet(String originalSetName, String newSetName) 
	{
		a1.updateOptionSet(originalSetName, newSetName);
    }

	
	public void modifyOption(String set, String opt, String name, int price) 
	{
		a1.updateOption(set, opt, name, price);
	}
	
	public void print() 
	{
		a1.printModel();
	}
}
