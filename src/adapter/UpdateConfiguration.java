package adapter;
/**
* Automotive Interface to Update the configuration of the Automotive objects
*/
public interface UpdateConfiguration 
{
    public void updateModel(String newModelName, int basePrice);
    public void updateOptionSet(String optSetName, String newName);
    public void updateOption(String optSetName, String optName, String newName, int newPrice);
    public void addOptionSet(String optSetName, int numOfOptions);
    public void addOption(String optSetName, String optName, int price);
    public void deleteOptionSet(int i);
    public void deleteOption(String optSetName, String optName);
}
