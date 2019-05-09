
import java.text.SimpleDateFormat;
import java.util.Calendar;
class AqscTs
{
	public static void main(String[] args) 
	{
		int f = 0;
		try
		{
			f = daysBetween("2019-03-05", "2016-06-29");
		}
		catch (Exception ex)
		{}

		System.out.println((f + 0) + "");
	}

	public static int daysBetween(String smdate, String bdate) throws Exception
	{  
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
		Calendar cal = Calendar.getInstance();
 
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();      
		
		cal.setTime(sdf.parse(bdate));    
		long time2 = cal.getTimeInMillis();  
		
		long between_days=(time1-time2)/(1000*3600*24);  

	    return Integer.parseInt(String.valueOf(between_days));     
	} 
}
