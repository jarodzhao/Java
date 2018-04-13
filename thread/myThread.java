public class myThread implements Runnable
{
	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;

	public myThread(){}

	public myThread(int countDown){
		this.countDown = countDown;
	}

	public String status(){
		String ref = "";
		if(countDown > 0)
			ref = "#" + id + " --> " + countDown;
		else
			ref = id + " 进程结束！！";
		return ref;
	}

	// 实现 Runnable 接口的类必须有 run() 方法
	// 处理比较耗时间的任务，可以把一个任务分成多个线程
	public void run(){
		while(countDown-- > 0){
			System.out.println(status());

			// 将CPU从一个线程切换到另一个线程
			Thread.yield();
		}
	}
}
