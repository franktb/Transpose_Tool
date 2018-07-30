package logic;

import java.util.HashMap;
import java.util.Map;

public class SongTransposer {
	private Map<String, String> transposeMap = new HashMap<>();
	private Map<String, String> enharmonicConfusion = new HashMap<>();
	
	private Map<String, String> prepareMap = new HashMap<>();
	

	/**
	 * constructor which also sets up the replacement map for the enharmonic
	 * confusion
	 */
	public SongTransposer() {
		enharmonicConfusion.put("Des", "Cis");
		enharmonicConfusion.put("Es", "Dis");
		enharmonicConfusion.put("Ges", "Fis");
		enharmonicConfusion.put("As", "Gis");
		enharmonicConfusion.put("B", "Ais");
		
		
		/*
		prepareMap.put("c", "C");
		prepareMap.put("d", "D");
		prepareMap.put("e", "E");
		prepareMap.put("f", "F");
		prepareMap.put("g", "G");
		prepareMap.put("a", "a");
		prepareMap.put("h", "H");
		
		prepareMap.put("cis", "Cis");
		*/
		
		//String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
		
		
	}

	public void buildLookupTable(int distance) {
		NoteTranspose noteTranspose = new NoteTranspose();
		int Offset = noteTranspose.getOffset(distance);
		this.transposeMap.put("F", noteTranspose.transpose("F", Offset));
		this.transposeMap.put("C", noteTranspose.transpose("C", Offset));
		this.transposeMap.put("G", noteTranspose.transpose("G", Offset));
		this.transposeMap.put("D", noteTranspose.transpose("D", Offset));
		this.transposeMap.put("A", noteTranspose.transpose("A", Offset));
		this.transposeMap.put("E", noteTranspose.transpose("E", Offset));
		this.transposeMap.put("H", noteTranspose.transpose("H", Offset));
		this.transposeMap.put("Fis", noteTranspose.transpose("Fis", Offset));
		this.transposeMap.put("Cis", noteTranspose.transpose("Cis", Offset));
		this.transposeMap.put("Gis", noteTranspose.transpose("Gis", Offset));
		this.transposeMap.put("Dis", noteTranspose.transpose("Dis", Offset));
		this.transposeMap.put("Ais", noteTranspose.transpose("Ais", Offset));
	}

	/**
	 * 
	 * @param note note which shall pepared for internal transpose process
	 * preparing means unifing upper and lower cases and removing enharmonic confusion
	 * @return prepared note
	 */
	public String prepare(String note) {
		String modified_note = note.substring(0, 1).toUpperCase() + note.substring(1);
		if(enharmonicConfusion.containsKey(modified_note)) {
			modified_note = enharmonicConfusion.get(modified_note);
		}
		return modified_note; 
		
	}
	
	/**
	 * transposes a given note depending on the initialized offset
	 * @param note
	 * @return
	 */
	public String transpose(String note) {
		return this.transposeMap.get(note);
	}

	public static void main(String[] args) {
		String testString = "A B C H Fis";
		String extractedNote = "";

		SongTransposer songtranspo = new SongTransposer();
		songtranspo.buildLookupTable(-1);
		System.out.println(songtranspo.prepare("cis"));
		//System.out.println(songtranspo.transposeMap.get(songtranspo.prepare("cis")));
		System.out.println(songtranspo.transpose(songtranspo.prepare("Des")));
		// map.put("C", "D");
		// System.out.println(map.get("C"));

	}

}
