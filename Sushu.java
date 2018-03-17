
class Sushu
{
	// Ñ°ÕÒËØÊı
	public static void println(Object...o){
		if (o.length < 1)
			System.out.println("");
		else
			System.out.println(o[0].toString());
	}

	public static void print(Object...o){
		System.out.print(o.toString());
	}

	public static void main(String[] args){
		int n = 20;
		boolean flag;
		for (int i=2; i<n; i++)
		{
			flag = false;
			for (int j=2; j<i; j++)
			{
				if (i % j == 0)
				{
					System.out.printf("%d %% %d = ", i, j);
					println(i%j + " ±»Õû³ı£¡");
					flag = true;
					break;
				}
			}
			if (!flag)
				println(" ------------- " + i + " ------------- ");
			println();
		}
	}
}