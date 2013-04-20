package util;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import model.Automotive;

public class DeSerializeIO 
{
	private String fileName;
	
	public DeSerializeIO()
	{
		super();
	}
	
	public DeSerializeIO(String fileName)
	{
		this.fileName = fileName;
	}

	public String getFileName() 
	{
		return fileName;
	}

	public void setFileName(String fileName) 
	{
		this.fileName = fileName;
	}
	
	public void deSerialize(Automotive model)
	{
		try
        {
            ObjectInputStream input =  new ObjectInputStream(new FileInputStream(fileName));
            model = (Automotive) input.readObject();
            input.close();
        } 
        catch (Exception e)
        {
            System.out.print("DeSerilization Error: " + e);
        }
	}
	
	public void deSerialize(Automotive model, String fileName)
	{
		this.fileName = fileName;
		deSerialize(model);
	}
	
	public Automotive deSerialize(String fileName)
	{
		Automotive tempAuto = new Automotive();
		deSerialize(tempAuto, fileName);
		return tempAuto;
	}
	
	public static void main(String[] args)
	{
		
	}
}
