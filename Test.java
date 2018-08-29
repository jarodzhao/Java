import java.util.*;
import java.text.*;

class Test
{
	public static void main(String[] args) throws ParseException
	{
		String a = "2018-08-09 09:50:00至2018-08-09 12:51:55在临颍 中午吃饭时段检查临颍车站作业标准执行情况。&&2018-08-14 07:00:00至2018-08-14 11:48:47在小李庄 jarod@zht&&2018-08-13 13:00:00至2018-08-13 17:42:23在小李庄 测试&&2018-08-06 15:00:00至2018-08-06 15:44:29在郑州车务段 检查调车分析台月度全覆盖情况&&2018-08-01 10:00:00至2018-08-01 12:33:23在圃田西站货装车间 检查圃西货装&&2018-08-04 11:30:00至2018-08-04 12:54:59在南阳寨 检查南阳寨行车室作业标准执行情况&&2018-08-14 07:00:00至2018-08-14 11:14:45在办公室 方法&&2018-08-07 11:30:00至2018-08-07 15:09:01在南阳寨 11:30-12:40车站吃饭时间段检查。&&2018-08-10 13:00:00至2018-08-10 15:19:50在安全生产调度指挥中心 指挥中心盯控铁炉工务封锁抢修13号道岔&&2018-08-10 21:00:00至2018-08-11 01:52:17在广武 0:30-1:30&&2018-08-12 23:00:00至2018-08-13 03:33:09在安全生产调度指挥中心 2:00-3:10指挥中心检查各站信号楼接发列车标准。&&";
		String[] b = a.split("&&");

		System.out.println(b.length);
		System.out.println(a.contains("&&"));

		System.out.println(System.currentTimeMillis());
		System.out.println("----------------------------------------");

		String d1 = "2018-08-28";
		String d2 = "2018-08-24";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date t1 = sdf.parse(d1);
		Date t2 = sdf.parse(d2);

		System.out.println(t1 + "/" + t2);
		System.out.println(t1.getTime() > t2.getTime());
	}
}