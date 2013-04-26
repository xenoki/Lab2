package adapter;
/** 
* Abstract class ProxyAutomtive
* User abstract class to hide the functionality
* You don't want to instantiate 
* You don't have an idea on how to implement the method so you declare for them to use later
* You know what you want but don't know how to do it.
* Create an abstract class with methods - enforce a contract and get others to code to the
* contact
* You can also create getter and setter for abstract class
*/
public abstract class ProxyAutomotive 
{	
    public abstract void updateModelNameAndPrice(String newModelName, int newBasePrice);
    public abstract void updateOptionSet(String optSetName, String newName);
    public abstract void updateOption(String optSetName, String optName, String newName, int newPrice);
    public abstract void addOptionSet(String optSetName, int numOfOptions);
    public abstract void addOption(String optSetName, String optName, int price);
    public abstract void deleteOptionSet(String optSetName);
    public abstract void deleteOptionSet(int i);
    public abstract void deleteOption(String optSetName, String optName);
}
