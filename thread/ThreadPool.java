import java.util.concurrent.*;

public class ThreadPool
{
	public static void main(String[] args) 
	{
		// 线程（执行）管理器
		// ExecutorService exec = Executors.newCachedThreadPool();

		// 启用 5 个线程同时并发
		ExecutorService exec = Executors.newFixedThreadPool(3);
		
		// 5 个任务
		for(byte i=0;i<5;i++)
			exec.execute(new myThread());

		exec.shutdown();
	}
}
