import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;

class Test_base64
{
	// base64 º”√‹Ω‚√‹
	public static void main(String[] args) throws ParseException, UnsupportedEncodingException
	{
		Base64 base64 = new Base64();
		String newStr = base64.encode("’‘");
		System.out.println(newStr);

		String newStr2 = base64.decode(newStr);
		System.out.println(newStr2);
	}
}