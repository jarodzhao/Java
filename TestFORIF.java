class TestFORIF 
{
	public static void main(String[] args) 
	{
		//测试FOR循环中的IF中的 RETURN 是否能跳出 FOR

		for(int i=1;i<=3;i++)
		{
			if(i!=2){
				return;
			}

			System.out.println(i);
		}
	}
}
