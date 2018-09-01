package com.fh.util;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

/**
* 筛选 List 的通用 <泛型方法>，利用反射调用对象方法
* @auth: zht
* @date: 2018-09-01 17:23
* 郑州车务段应急指挥项目
*/
public class OrderTools
{
	public static <T> List<T> screenedList(List<T> list, Class<T> clz, String exec_status, String exec_time) throws Exception
	{
		// 进入过程时，exec_status 或者 exec_time 肯定有一个值是 非 null
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(new Date());

		Iterator<T> iter = list.iterator();
		
		while (iter.hasNext())
		{
			// 初始化状态值
			int status = -1;
			T obj = iter.next();
			Method method = clz.getDeclaredMethod("getExec_time");
			
			//获取命令的执行时间
			String execTime = (String) method.invoke(obj);
			
			if (execTime == null)
			{
				iter.remove(); // 历史数据，没有执行时间，直接排除
				continue;
			} else
			{
				String[] days = execTime.split(",");

				String startDay = days[0];
				String endDay = "";

				if (days.length > 1)
					endDay = days[days.length - 1];
				else
					endDay = days[0];

				long start = sdf.parse(startDay).getTime();
				long end = sdf.parse(endDay).getTime();
				long to = sdf.parse(today).getTime();

				if (to < start)
				{
					status = 0;
				} else if ((to >= start) && (to <= end))
				{
					if (execTime.contains(today))
						status = 1;
					else
						status = 2;
				} else if (to > end)
				{
					status = 3;
				}
				
				// 根据条件判断
				if ((exec_status != null && exec_status.length() > 0) && (exec_time != null && exec_time.length() > 0))
				{
					if (status != Integer.parseInt(exec_status) || !execTime.contains(exec_time))
						iter.remove();
				} else if (exec_status != null && exec_status.length() > 0) // 查询执行状态
				{
					if (status != Integer.parseInt(exec_status))
						iter.remove();
				} else if (exec_time != null && exec_time.length() > 0) // 查询执行时间
				{
					if (!execTime.contains(exec_time))
						iter.remove();
				}
			}
		}
		return list;
	}

}