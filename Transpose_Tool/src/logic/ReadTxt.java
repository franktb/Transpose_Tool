package logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadTxt {
	
	private String filename;
	private File file;
	
	private String songString;

	public ReadTxt(String filename) {
		this.filename = filename;
		file = new File(this.filename);
		
		try (FileInputStream inputStream = new FileInputStream(file)) {
			int content;

			while ((content = inputStream.read()) != -1) {
				// convert to char and display it
				songString= songString + (char) content;
			}
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getSongString() {
		return songString;
	}
	
}
