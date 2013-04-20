package Adapter;
import Model.*;
public abstract class proxyAutomotive {
	private Automotive a1; //Maybe you do not need this.
	//a1 is the hook to Model package functionality.
	
	public void readFile(String filename)
	{
		//Call methods in Util to build Automotive object.
		System.out.println("ProxyAutomotive building Auto");
	}
	public void print() {
		System.out.println("Printing Automotive Properties");
	}
}
