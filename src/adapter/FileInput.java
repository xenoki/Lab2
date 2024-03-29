package adapter;
/**
* @author hquach
* API for FileInput
* Enforce a contract between classes for methods
* Enable Polymorphism 
* Define API
* 
* Class can implement multiply interfaces
* Neither Interface and Abstract Class can not be instantiated
*/
public interface FileInput 
{   
    public void readFile(String fileName);
    public void print();
    public void updateModel(String newModelName, int basePrice);
    public void updateOptionSet(String optSetName, String newName);
    public void updateOption(String optSetName, String optName, String newName, int newPrice);
    public void addOptionSet(String optSetName, int numOfOptions);
    public void addOption(String optSetName, String optName, int price);
    public void deleteOptionSet(int i);
    public void deleteOption(String optSetName, String optName);
}
