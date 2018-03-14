// import java.util.Random;

class Test
{
	public static void main(String[] args)
	{
		int r0 = 0;
		for(;;){
			int r = (int)(Math.random()*25);
			if (r > r0)
			{
				System.out.print(r0 + " < " + r);
			}else{
				System.out.print(r0 + " > " + r);
			}
			System.out.print(" | ");
			r0 = r;
		}
	}
}