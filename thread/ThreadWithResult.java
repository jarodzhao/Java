import java.util.concurrent.*;
import java.util.*;

class ThreadWithResult
{
	public static void main(String[] args){
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<>();

		// 循环 10 次，把 i 值传入新线程中
		for(byte i=0;i<10;i++)

			// submit 方法执行线程，并返回线程执行的结果
			results.add(exec.submit(new CallableDemo(i)));

		// 遍历 results ，输出其中的所有值（Future）
		for(Future<String> fs:results){
			try
			{
				System.out.println(fs.get());
			}
			catch (InterruptedException e)
			{
				System.out.println(e);
				return;
			}
			catch (ExecutionException e)
			{
				System.out.println(e);
			}
			finally
			{
				exec.shutdown();
			}
		}
	}
}

// 可以返回结果的线程对象
class CallableDemo implements Callable<String> 
{
	private int id;
	
	// 构造线程时接收一个参数 id
	public CallableDemo(int id){
		this.id = id;
	}

	// 输出线程构造实例时接收的 id
	public String call(){
		return id + " thread...";
	}
}
