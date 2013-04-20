package driver;
import adapter.AutomotiveAPI;
import adapter.BuildAuto;
/**
* Hung Quach
* CIS 35B
* Lab 1:
* Due Date:       4/15/2013
* Date Submitted: 4/15/2013
*/
public class Main 
{
    public static void main(String[] args) 
    {
    	AutomotiveAPI api = new BuildAuto();
		api.readFile("FordZTW.txt");
		api.print();
		api.modifyNameAndBasePrice("Hung Quach", 15000);
		api.modifyOption("Color", "Pitch Black Clearcoat", "Wicked Green", 200);
		api.modifyOptionSet("Transmission", "Thingy");
		api.print();
    }
}
