import java.util.*;

class ThreadDemo extends Thread 
{
	static ArrayList<String> al = new ArrayList();
	static List<String> av = new Vector<>();

	public void run()
	{
		synchronized(al){
			av.add("1");
		}
		// 打印线程名称等相关信息
		System.out.println(Thread.currentThread());
	}

	public static void main(String[] args) 
	{
		for(int i=0;i<101;i++)
		{
			ThreadDemo td = new ThreadDemo();
			td.start();
		}
		System.out.println(av.size());
	}
}
