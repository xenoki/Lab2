package temp;
/**
* Automotive API 
*/
public interface AutomotiveAPI 
{   
    public void readFile(String filename);
    public void update(String modelName, int basePrice);
    public void update(String optSetName, String newName);
    public void update(String optSetName, String optName, String newName, int newPrice );
    public void add(String optSetName, int numOfOptions);
    public void add(String optSetName, String optName, int price);
    public void delete(String optSetName);
    public void delete(String optSetName, String optName);
    public void print();
}
