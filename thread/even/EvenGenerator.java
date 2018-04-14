public class EvenGenerator extends IntGenerator {

	private int currentEvenValue = 0;

	public int next() {
		++currentEvenValue;
		++currentEvenValue;
		return currentEvenValue;
	}

	public static void main(String[] args) {
	
		// 直接调用默认包下的静态类中的静态方法
		EvenChecker.test(new EvenGenerator());
	}
}


