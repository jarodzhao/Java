public class PersonA extends Thread 
{
	Bank bank;

	// 通过构造器传入银行对象，确保两个人进入的是同一个银行（线程）
	public PersonA(Bank bank) {
		this.bank = bank;
	}

	@Override
	public void run() {
		while (Bank.money >= 100)
		{
			// 柜台取钱操作
			bank.Counter(100);
			try
			{
				sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
