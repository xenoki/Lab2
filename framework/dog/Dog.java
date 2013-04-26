package dog;

public class Dog 
{
    private String name;
    
    public Dog()
    {
        
    }
    
    public Dog(String name)
    {
        this.name = name;
    }
    
    public String getName() 
    {
        return name;
    }
    
    public void setName(String name) 
    {
        this.name = name;
    }
    
    public void foo(Dog d)
    {
        d.setName("Max");     // AAA
        d = new Dog("Fifi");  // BBB
        d.setName("Rowlf");   // CCC
    }
    
    /**
    * you're essentially passing the address of the created Dog object 
    * to the foo method. Using that address, you can change the value
    * of that object in that address. However, you can't change that
    * address. Java actually pass the value of that address to the 
    * method foo. Think of reference parameters as being aliases for the variable passed in. 
    * When that alias is assigned, so is the variable that was passed in. 
    * Keeping in mind that myDog is a pointer, and not an actual Dog, 
    * the answer is NO. myDog still has the value 42; it's still pointing 
    * to the original Dog. Follow the pointer in the method and change the 
    * data that was pointed to. However, you cannot change where that 
    * pointer points. Very important concept, in java once you a variable
    * with the reference value of a pointer
    * new Dog(), this is an object
    * dog, this is pointer to the Dog object reference memory. You can't assigned
    * value to value,
    * @param args
    */
    public static void main(String[] args)
    {
        Dog dog = new Dog();
        dog.foo(dog);
        System.out.println(dog.getName());
    }
    
}
