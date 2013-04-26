package adapter;
/**
* 
* @author hquach
*
*/
public interface CRUD 
{
    // Create
    public void addOptionSet(String optSetName, int numOfOptions);
    public void addOption(String optSetName, String optName, int price);
    
    // Read 
    public String readOptionSet(int index);
    public String readOption(String optionSetName, int index);
    
    // Update
    public  void updateModelNameAndPrice(String newModelName, int newBasePrice);
    public  void updateOptionSet(String optSetName, String newName);
    public  void updateOption(String optSetName, String optName, String newName, int newPrice);
    
    // Delete
    public  void deleteOptionSet(String optSetName);
    public  void deleteOptionSet(int i);
    public  void deleteOption(String optSetName, String optName);
}
