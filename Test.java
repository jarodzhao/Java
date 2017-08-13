import java.util.*;

class Test 
{
	//测试 JAVA 程序运行时间
	public static void main(String[] args) 
	{
		long s1 = 0;
		long s2 = 0;
		long s3 = 0;
		int sum = 0;

		try
		{
			Random random = new Random();
			List<String> list = new ArrayList<String>();

			//循环(生成随机数)开始时间
			s1 = System.currentTimeMillis();

			for(int i=0;i<1000000;i++)
				list.add(random.nextInt() + "");

			// xxx 次循环完毕时间
			s2 = System.currentTimeMillis();

			//同时也是 xxx 次循环(查找)开始时间
			for(String a : list)
			{
				if (a.indexOf("99999") > 0)
				{
					sum++;
					System.out.println(a);

					//取消注释后,可计算找到第一个符合要求的数值用时
					//return;
				}
			}
		}
		catch (Exception e)
		{ }
		finally
		{
			// 查找循环完毕时间
			s3 = System.currentTimeMillis();

			System.out.println();
			System.out.println(sum + " 个");
			System.out.println();
			System.out.println(s2 - s1);
			System.out.println(s3 - s2);
		}
	}
}
