class TestIF
{
	//地图坐标对比测试，三个区域
	public static void main(String[] args){
		//目标坐标
		int ltx = 7;
		int lty = 20;

		int a1x = 2;	//A区域坐标
		int a1y = 2;
		int a2x = 4;
		int a2y = 6;
		
		int b1x = 5;	//B区域坐标
		int b1y = 9;
		int b2x = 8;
		int b2y = 14;
		
		int c1x = 5;	//C区域坐标
		int c1y = 19;
		int c2x = 8;
		int c2y = 24;

		if (((ltx > a1x && ltx < a2x) && (lty > a1y && lty < a2y)) || 
			((ltx > b1x && ltx < b2x) && (lty > b1y && lty < b2y)) || 
			((ltx > c1x && ltx < c2x) && (lty > c1y && lty < c2y))){
			System.out.println(true);
		}else{
			System.out.println(false);
		}

		System.out.println();
		System.out.println("ltx = " + ltx);
		System.out.println("lty = " + lty);

		System.out.println();
		System.out.println(ltx + ">" + a1x + " = " + (ltx > a1x));
		System.out.println(ltx + "<" + a2x + " = " + (ltx < a2x));
		System.out.println(lty + ">" + a1y + " = " + (lty > a1y));
		System.out.println(lty + "<" + a2y + " = " + (lty < a2y));
		System.out.println(((ltx > a1x && ltx < a2x) && (lty > a1y && lty < a2y)));
		System.out.println();
		
		System.out.println(ltx + ">" + b1x + " = " + (ltx > b1x));
		System.out.println(ltx + "<" + b2x + " = " + (ltx < b2x));
		System.out.println(lty + ">" + b1y + " = " + (lty > b1y));
		System.out.println(lty + "<" + b2y + " = " + (lty < b2y));
		System.out.println(((ltx > b1x && ltx < b2x) && (lty > b1y && lty < b2y)));
		System.out.println();
		
		System.out.println(ltx + ">" + c1x + " = " + (ltx > c1x));
		System.out.println(ltx + "<" + c2x + " = " + (ltx < c2x));
		System.out.println(lty + ">" + c1y + " = " + (lty > c1y));
		System.out.println(lty + "<" + c2y + " = " + (lty < c2y));
		System.out.println(((ltx > c1x && ltx < c2x) && (lty > c1y && lty < c2y)));

		System.out.println();
		System.out.println(true || false); //三个区域中一个包含
		System.out.println(true && false); //三个区域都包含
	}
}
