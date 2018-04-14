public abstract class IntGenerator 
{
	public volatile boolean canceled = false;

	public abstract int next();
	
	public void cancel() { canceled = true; }

	public boolean isCanceled() { return canceled; }

}
