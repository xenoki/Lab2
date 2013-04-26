package model;
import java.io.Serializable;
import java.util.ArrayList;
import adapter.ProxyAutomotive;
/**
* This class provide an Automotive object in which you can store, serialize, 
* and print the model name, base price, and the set of options for a car 
* configuration
*/
public class Automotive extends ProxyAutomotive implements Serializable 
{
    // Constants ================================================================================
    private static final long serialVersionUID = -5105910834572049363L;
    private final int DEFAULT_OPTIONSET = 5;
    
    // Properties ===============================================================================

    private String name;
    private int price;
    private ArrayList<OptionSet> optionset;
    
    // Constructors =============================================================================
    
    public Automotive() 
    {
        super();
        optionset = new ArrayList<OptionSet>(DEFAULT_OPTIONSET);
    }
    
    public Automotive (String modelName, int basePrice, int initialOptSet)
    {
        super();
        this.name = modelName;
        this.price = basePrice;
        optionset = new ArrayList<OptionSet>(initialOptSet);
    }
    
    public Automotive(String name, int price) 
    {   
        super();
        this.name = name;
        this.price = price;
        optionset = new ArrayList<OptionSet>(DEFAULT_OPTIONSET);
    }
    
    public Automotive(String name) 
    {
        super();
        this.name = name;
    }
    
    public Automotive(int price)
    {
        super();
        this.price = price;
    }

    // Getters/Setters ==========================================================================

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getPrice() 
    {
        return price;
    }

    public void setPrice(int price) 
    {
        this.price = price;
    }
    
    // Methods ==================================================================================
   
    /**
    * Find the optionSet with a specified name in the array list and return that 
    * optionSet, return null if not found. 
    * @param optionSetName the name of the Option set to search for
    * @return the match optionSet object
    */
    public OptionSet matchOptionSet(String optionSetName)
    {
        boolean found = false;
        int i = 0;
        while(!found && i < optionset.size())
        {
            if(optionset.get(i).getName().equalsIgnoreCase(optionSetName))
            {
                found = true;
            }
            else 
            {
                i++;
            }
        }
        return (found) ? optionset.get(i) : null;
    }
    
    /**
    * Return the option set based on the specified index 
    * @param i the location of the element
    * @return a option set object
    */
    public OptionSet matchOptionSet(int i)
    {
        try
        {
            return optionset.get(i);

        } 
        catch (IndexOutOfBoundsException e)
        {
            System.out.printf("Error: %s", e);
            return null;
        } 
    }
    
    /** 
    * Returns the String representation of Automotive for debugging and 
    * logging purposes.
    * @see java.lang.Object#toString()
    */
    public String toString()
    {
        return String.format("Automotive[ name = %s,  price = %d, optionset = %s]",
                name, price, optionset);
    }
    
    /**
    * Print the configuration data of the Automotive object 
    */
    public void print()
    {
        System.out.println("Printing from Automotive");
        System.out.printf("Model name: %s\n", name);
        System.out.printf("Base price: %d\n", price);
        for(int i = 0; i < optionset.size(); i++)
        {
            optionset.get(i).printOptionSet();
        }
    }
    
    // Overriding ProxyAutomotive method
    
    /**
    * Update the model name and price 
    */
    public void updateModelNameAndPrice(String newModelName, int newBasePrice) 
    {
        this.name = newModelName;
        this.price = newBasePrice;
    }

    /**
    * Add a new option Set 
    */
    public void addOptionSet(String optSetName, int numOfOptions) 
    {
        optionset.add(new OptionSet(optSetName, numOfOptions));
    }

    /**
    * Give a option set name, add in a new option 
    */
    public void addOption(String optSetName, String optName, int price) 
    {
        matchOptionSet(optSetName).addNewOption(optName, price);
    }
    
    /**
    * Update the name of the option set. 
    */
    public void updateOptionSet(String optSetName, String newName) 
    {
        matchOptionSet(optSetName).setName(newName);
    }

    @Override
    public void updateOption(String optSetName, String optName, String newName, int newPrice) 
    {
        matchOptionSet(optSetName).getOption(optName).update(newName, newPrice);
    }
    
    @Override
    public void deleteOptionSet(String optSetName) 
    {
        optionset.remove(matchOptionSet(optSetName));
    }

    @Override
    public void deleteOptionSet(int i) 
    {
        optionset.remove(i);
    }

    @Override
    public void deleteOption(String optSetName, String optName) 
    {
        matchOptionSet(optSetName).deleteOption(optName);
    }
}
