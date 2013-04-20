package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
* Hung Quach
* CIS 35B
* Lab 1:
* Due Date:       4/15/2013
* Date Submitted: 4/15/2013
*
* This class provide an Automotive object in which you can store, serialize, 
* and print the model name, base price, and the set of options for a car 
* configuration
*/
public class Automotive implements Serializable 
{
    // Constants ========================================================

    private static final long serialVersionUID = -5105910834572049363L;
    private final int DEFAULT_OPTIONSET = 5;
    
    // Properties =======================================================

    private String name;
    private int price;
    private ArrayList<OptionSet> optionset;
    
    // Constructors =====================================================
    
    public Automotive() 
    {
        optionset = new ArrayList<OptionSet>(DEFAULT_OPTIONSET);
    }

    public Automotive(String name) 
    {
        this.name = name;
        optionset = new ArrayList<OptionSet>(DEFAULT_OPTIONSET);
    }
    
    public Automotive(int price)
    {
        this.price = price;
        optionset = new ArrayList<OptionSet>(DEFAULT_OPTIONSET);
    }

    public Automotive(String name, int price) 
    {   
        this.name = name;
        this.price = price;
        optionset = new ArrayList<OptionSet>(DEFAULT_OPTIONSET);
    }
    
    public Automotive(String name, int price, int size) 
    {
        this.name = name;
        this.price = price;
        optionset = new ArrayList<OptionSet>(size);
    }

    public Automotive(String name, int price, ArrayList<OptionSet> optionset) 
    {
        this.name = name;
        this.price = price;
        this.optionset = optionset;
    }
    
    // Getters/Setters ==================================================

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
    
    public ArrayList<OptionSet> getOptionset() 
    {
        return optionset;
    }

    public void setOptionset(ArrayList<OptionSet> optionset) 
    {
        this.optionset = optionset;
    }
    
    // Methods ==========================================================
    
    /**
    * Add a new option set to the array list of option set. 
    * @param name           the name of the option set
    * @param numOfOptions   the initial number of product it can hold before
    *                       allocating more space
    */
    public void addOptionSet(String name, int numOfOptions)
    {
        optionset.add(new OptionSet(name, numOfOptions));
    }
    
    /**
    * Add an option to a specified set. Call method matchOptionSet to find
    * the option set to add the option. 
    * @param optSetName the name of the option set
    * @param name       the name of the option
    * @param price      the price of the option
    */
    public void addOptionToSet(String optSetName, String name, int price)
    {
        matchOptionSet(optSetName).addNewOption(name, price);
    }
    
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
    * Print the configuration data of the automobile object
    */
    public void printModel()
    {
        System.out.printf("Model name: %s\n", name);
        System.out.printf("Base price: %d\n", price);
        for(int i = 0; i < optionset.size(); i++)
        {
            optionset.get(i).printOptionSet();
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
     
    // CRUD Methods =====================================================
    
    /**
    * Create a new OptionSet object
    * @param optionSetName the name of the option set
    * @param size the initial size of option array list
    * @return the OptionSet object
    */
    public OptionSet createNewOptionSet(String optionSetName, int size)
    {
        return new OptionSet(optionSetName, size);
    }
    
    /**
    * Create a new Option object
    * @param name the name of the option
    * @param price the price of the option
    * @return the Option object
    */
    public OptionSet.Option createNewOption(String name, int price)
    {
        return new OptionSet().new Option(name, price);
    }
    
    /**
    * Get the specified option set 
    * @param optionSetName the name of the option set
    * @return the option set object
    */
    public OptionSet readOptionSet(String optionSetName)
    {  
        return matchOptionSet(optionSetName);
    }
    
    /**
    * Get a option in a specified Option set 
    * @param optionSetName the name of the
    * @param name the name of the option 
    * @return the option object
    */
    public OptionSet.Option readOption(String optionSetName, String name)
    {
        try
        {
            return matchOptionSet(optionSetName).getOption(name);

        }
        catch (NullPointerException e)
        {
            System.out.printf("Error %s\n", e);
            System.out.printf("Unable to read option from %s Option Set\n", optionSetName );
            return null;
        }
    }
    
    /**
    * Update the name of the option set, throws null pointer error if unable
    * to update
    * @param optSetName the name of the option set to update
    * @param name the new name that will be use to change the previous name
    */
    public void updateOptionSet(String optSetName, String name)
    {
        try
        {
            matchOptionSet(optSetName).setName(name);
        } 
        catch (NullPointerException e)
        {
            System.out.printf("Error: %s\n", e);
            System.out.printf("Unable to find %s to update\n",optSetName);
        }
    }
     
    /**
    * Update the option in a specified option set 
    * @param optSetName the name of the option set 
    * @param name the new name of the option
    * @param price the new price of the option
    */
    public void updateOptionInOptionSet(String optSetName, String name, int price)
    {
        try
        {
            matchOptionSet(optSetName).setOption(name, price);

        } catch (NullPointerException e)
        {
            System.out.printf("Error: %s\n", e);
            System.out.printf("Unable to find Option Set %s to update\n", optSetName);
        }
    }
     
    /**
    * Delete an option set in the array list bases on index location throw a
    * index out of bound error if the element doesn't not exist
    * @param i the location of the option set in the array list to be deleted
    */
    public void deleteOptionSet(int i)
    {   
        try
        {
            optionset.remove(i);

        } 
        catch (IndexOutOfBoundsException e)
        {
            System.out.printf("Error: %s\n", e);
            System.out.printf("Location of OptionSet does not exist to delete\n");
        }
    }
    
    /**
    * Delete an option set in the list base on index location
    * @param name
    */
    public void deleteOptionSet(String name)
    {
        optionset.remove(matchOptionSet(name));
    }
    
    public static void main(String[] args)
    {
        Automotive test = new Automotive();
        test.matchOptionSet(200);
    }
}
