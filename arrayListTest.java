import java.util.List;
import java.util.ArrayList;

class arrayListTest 
{
	public static void main(String[] args) 
	{
		List<String[]> list = new ArrayList<>();
		String[] ss = new String[5];

		for(byte i=0; i<5; i++)
		{
			System.out.println(ss.length);
			ss[i] = "a #" + i;
		}

		list.add(ss);
		System.out.println(ss.length);
	}
}
