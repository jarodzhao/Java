import java.util.Random;

// 售票大厅
public class Station extends Thread {

	public Station(String name) {
		super(name);
	}

	// 总票数
	static int tick = 20;

	// ？？？？？？ 钥匙
	static Object ob = "aa";

	@Override
	public void run(){
		while (tick > 0) {
			synchronized(ob) {	//使用钥匙来锁 tick ???
				if (tick > 0) {
					System.out.println(getName() + "卖出了第 " + tick + " 张票");
					tick--;
				} else {
					System.out.println("票已经卖完了");
				}
			}
			try {
				sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
