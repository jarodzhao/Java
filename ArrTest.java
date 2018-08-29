import java.util.*;

class ArrTest 
{
	public static void main(String[] args) 
	{
		List<int[]> list = new ArrayList<>();
		int[] arr;

		for(int i=0;i<=5;i++){
			arr = new int[2];
			arr[0] = 1; arr[1] = 2;
			list.add(arr);
			System.out.println(arr.length);
		}

		System.out.println(list.toString());
	}
}
