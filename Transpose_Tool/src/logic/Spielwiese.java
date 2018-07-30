package logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Spielwiese {

	
	public static String EXAMPLE_TEST = "BCDE";
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
		String[] splitStr = mystring.split(" +");

		//Pattern note = Pattern.compile("([^\\w][ABCDEFGH]|[abcdefgh])(is|es|s)?");
		Pattern note = Pattern.compile("([ABCDEFGH]|[abcdefgh])(is|es|s)?");
		
		
		for (int i = 0; i < splitStr.length; i++) {
			System.out.print("Suchstring:"+splitStr[i]+" ");
			Matcher matcher = note.matcher(splitStr[i]);
			matcher.find();
			System.out.println("gefunden:"+matcher.group());
			
			String currentnote = matcher.group();
			
			SongTransposer songtranspo = new SongTransposer();
			songtranspo.buildLookupTable(-1);
			//System.out.println(songtranspo.prepare("cis"));
			//System.out.println(songtranspo.transposeMap.get(songtranspo.prepare("cis")));
			System.out.println(songtranspo.transpose(songtranspo.prepare(currentnote)));
		
		}
		
		
	}
}
