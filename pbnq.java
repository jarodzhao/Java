class pbnq 
{
    // 生成裴波那切数列
	public static void main(String[] args) 
	{
		long a = 1;
        long b = 2;
        long c = 0;

        System.err.println(a);
        System.err.println(b);

        // 最大数
        while(c < 100)
        {
            c = a + b;
            a = b;
            b = c;
            System.err.println(c);
        }
	}
}
