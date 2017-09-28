class TestSplit 
{
	public static void main(String[] args) 
	{
		String lt = "113.722371,34.754438;113.723961,34.752851;";

		String[] t = lt.split(";");

		//113.722371,34.754438
		//113.723961,34.752851


		for (int i=0;i<t.length ;i++ )
		{
			System.out.println(t[i]);
		}




		//System.out.println("Hello World!");
	}
}
