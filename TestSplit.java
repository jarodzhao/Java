class TestSplit 
{
	public static void main(String[] args) 
	{
		String[] temp = {"113.754449,34.770592;113.757755,34.768279;", "113.722371,34.754438;113.723961,34.752851;", "113.656884,34.815695;113.658941,34.814806;"};

		// temp 相当于数据库中的一条记录
		for (int i=0; i<temp.length; i++ )
		{
			String lt = temp[i];
			String[] ltemp = lt.split(";");

			//System.out.println(ltemp[0]);	//区域坐标A
			String[] lta = ltemp[0].split(",");
			System.out.println("lta[0]=" + lta[0]);
			System.out.println("lta[1]=" + lta[1]);

			//System.out.println(ltemp[1]);	//区域坐标B
			String[] ltb = ltemp[1].split(",");
			System.out.println("ltb[0]=" + ltb[0]);
			System.out.println("ltb[1]=" + ltb[1]);

			System.out.println();
		}
	}
}
