public class Bank 
{
	// 账户总额为 1000
	protected static int money = 1000;

	public void Counter(int money) {
		Bank.money -= money;
		System.out.println("柜台取走了 " + money + ", 还剩下 " + (Bank.money));
	}

	public void ATM(int money) {
		Bank.money -= money;
		System.out.println("ATM 取走了 " + money + ", 还剩下" + (Bank.money));
	}
}
