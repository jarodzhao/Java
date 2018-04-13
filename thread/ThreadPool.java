import java.util.concurrent.*;

public class ThreadPool
{
	public static void main(String[] args) 
	{
		// 线程（执行）管理器

		// 总是启用新线程
		ExecutorService exec = Executors.newCachedThreadPool();

		// 总是使用同一线程（队列执行任务）
		// ExecutorService exec = Executors.newSingleThreadExecutor();

		// 启用 5 个线程同时并发（固定线程数量）
		// ExecutorService exec = Executors.newFixedThreadPool(3);
		
		// 5 个任务
		for(byte i=0;i<5;i++)
			exec.execute(new myThread());

		exec.shutdown();
	}
}
