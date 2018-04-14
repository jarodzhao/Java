public class MainClass 
{
	public static void main(String[] args) 
	{
		Bank bank = new Bank();

		PersonA pA = new PersonA(bank);
		PersonB pB = new PersonB(bank);

		pA.start();
		pB.start();
	}
}

//https://www.cnblogs.com/pureEve/p/6524366.html