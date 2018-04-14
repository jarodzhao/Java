public class PersonB extends Thread 
{
	Bank bank;
	
	// 通过构造器传入银行对象，确保两个人进入的是同一个银行（线程）
	public PersonB(Bank bank) {
		this.bank = bank;
	}

	@Override
	public void run() {
		while (Bank.money >= 200)
		{
			// ATM 取款操作
			bank.ATM(200);
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
