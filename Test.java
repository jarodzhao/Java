// import java.util.Random;

class Test
{
	public static void main(String[] args)
	{
		//Random rand = new Random();
		//print(3 + 1.5);	// 自动转换为 Double 类型

		while(condition()){
			print("---------------------------");
		}
		print("Exited 'while'");
	}

	// 很巧妙的方法
	static boolean condition()
	{
		double i = Math.random();
		print(i);
		return i < 0.99;
	}

	// 简便的输出方法
	static void print(Object o)
	{
		// 判断对象是否为 String 类型
		if (o instanceof String)
			System.out.println(o);
		else {
			System.out.println(o.toString());
			System.out.println(o.getClass().toString());
		}
	}
}