import java.io.*;

class FileTest 
{
	public static void main(String[] args) 
	{
		File file = new File("d:/3.txt");
		try
		{
			System.out.println(file.exists());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
