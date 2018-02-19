package logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Spielwiese {
	private static String mystring = "";

	public static void main(String[] args) {

		// String str = "A B A C Fis\nGis C A B D"; System.out.println(str);

		File file = new File("src/logic/blubb.txt");

		try (FileInputStream inputStream = new FileInputStream(file)) {
			int content;

			while ((content = inputStream.read()) != -1) {
				// convert to char and display it
				mystring = mystring + (char) content;
			}
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(mystring);
		System.out.println();
		String[] splitStr = mystring.split("\\s+");

		for (int i = 0; i < splitStr.length; i++) {
			
		}
		

		
		
		
		
		
		
		
	}
	
	
	
	
	
	

}
