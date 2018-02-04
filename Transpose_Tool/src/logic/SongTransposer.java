package logic;

import java.util.HashMap;
import java.util.Map;

public class SongTransposer {
	private static Map<String, String> transposeMap = new HashMap<>();
	
	public void buildLookupTable(int distance) {
		NoteTranspose noteTranspose = new NoteTranspose();
		int Offset = noteTranspose.getOffset(distance);
		transposeMap.put("C", noteTranspose.transpose("C", Offset));
		
	}
	
	public static void main(String[] args) {
		String testString = "A B C H Fis";
		String extractedNote = "";
		
		SongTransposer songtranspo = new SongTransposer();
		songtranspo.buildLookupTable(-1);
		System.out.println(transposeMap.get("C"));
		
		//map.put("C", "D");
		//System.out.println(map.get("C"));
		
	}

}
