package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class A1
{
	public static void main(String[] args)
	{
		Random random = new Random();
		System.out.println(random.nextFloat());

//		int i;

		File file = new File("E:\\笔记\\java-file.txt");

		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		try {

			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);

			String line;
			while ((line = br.readLine()) != null)
				System.out.println(line);
				
//			while ((i = isr.read()) != -1)
//				System.out.println((char) i);

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			if (br != null) {

				try {

					br.close();

				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
	}
}
