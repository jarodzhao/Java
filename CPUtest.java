import java.util.*;

class CPUtest
{
	public static void main(String[] args) 
	{
		Random rand = new Random();

		for(int i=0;i<99;i++){
			Double d = rand.nextDouble() * i;

			System.out.println(d.toString() + " jarod #" + i);
		}
	}
}
