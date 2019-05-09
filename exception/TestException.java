class TestException
{
	public static void main(String[] args) 
	{
		try
		{
			if(1 > 2) {
				throw new myException(0, "一切正常！");
			} else {
				throw new myException(1, "有情况...");
			}
		}
		catch (Exception e)
		{
			System.out.println(e.msg);
			e.printStackTrace();
		}
	}
}
