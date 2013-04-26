package driver;
import adapter.BuildAuto;
import adapter.FileInput;
/**
* Driver Class
*/
public class Main 
{
    public static void main(String[] args) 
    {
        FileInput model = new BuildAuto();
        model.readFile("FordZTW.txt");
        model.print();
    }
}
