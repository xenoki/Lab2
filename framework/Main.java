import Adapter.*;
public class Main {
	public static void main(String [] m)
	{
		FileInput a1 = new BuildAuto();
		a1.readFile("abcd");
		a1.print();
	}
}
