import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ScrList {
    public static void main(String[] args) throws Exception{
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add("#" + i);
        }
        scrList(list, String.class);

        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list2.add(i);
        }
        scrList(list2, Integer.class);
    }

	// 反射的调用
    public static <T> List<T> scrList(List<T> list, Class<T> clz) throws Exception {

        for (int i = 0; i < list.size(); i++) {

            T t = list.get(i);

			// 获取对象的方法
            Method method = clz.getDeclaredMethod("toString");

			// 你要预先知道该方法返回的类型
            String ss = (String) method.invoke(t);

            System.out.println(t + " ---- " + t.getClass() + " ---- " + ss);

        }

        return list;
    }
}
