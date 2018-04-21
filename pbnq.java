class pbnq 
{
	public static void main(String[] args) 
	{
		long a = 1;
        long b = 2;
        long c = 0;

        System.err.println(a);
        System.err.println(b);

        while(c < 100)
        {
            c = a + b;
            a = b;
            b = c;
            System.err.println(c);
        }
	}
}
