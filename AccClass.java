import java.util.*;
import java.util.Map.*;

class  AccClass
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{
		// HashMap 的迭代方式
		HashMap<String, String> hm = new HashMap<>();

		for (byte i=0;i<10 ;i++ ){
			hm.put("name #" + i, "jarod #" + i);
		}

		// 第一种迭代方式
		for (String key : hm.keySet()){
			System.out.println(key + "||" + hm.get(key));
		}
		
		System.out.println();

		// 第二种迭代方式
		Iterator iter = hm.entrySet().iterator();
		while(iter.hasNext()){
			Entry<String, String> entry = (Entry<String, String>) iter.next();
			System.out.println(entry.getKey() + "||" + entry.getValue());
		}
		
		System.out.println();

		// 第三种迭代方式
		for (String v : hm.values() )
		{
			System.out.println(v);
		}

		System.out.println();

		// 第四种迭代方式
		for (Entry<String, String> entry : hm.entrySet())
		{
			System.out.println(entry.getKey() + "||" + entry.getValue());
		}

		System.out.println();
		System.out.println(hm.values());
		System.out.println();
		
		// HashMap 的排序
        List<Entry<String,String>> list = new ArrayList<Entry<String,String>>(hm.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
            public int compare(Entry<String, String> o1,
                    Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

		for(Entry<String, String> mapping:list){
			System.out.println(mapping.getKey() +"||"+ mapping.getValue());
		}
	}
}