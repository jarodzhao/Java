
// 抽象类，继承该类必须实现 next() 方法
public abstract class IntGenerator 
{
	public volatile boolean canceled = false;

	public abstract int next();
	
	public void cancel() {
		canceled = true;
	}

	public boolean isCanceled() {
		return canceled; 
	}
}
