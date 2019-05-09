import java.util.*;

class LambdaTest 
{
	public static void main(String[] args) 
	{
		String nick[] = {
			"jarodzhao",
			"ht_z",
			"zhaoht",
			"zhaohaitao",
			""
		};

		List<String> nicks = Arrays.asList(nick);



//		for 遍历
//		for(String nk : nick)
//			System.out.println(nk);


		// lambda 表达式
		nicks.forEach(nk -> System.out.println(nk));


		// 双冒号操作符（double colon operator）
		nicks.forEach(System.out::println);


	}
}
