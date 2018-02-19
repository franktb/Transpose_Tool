package logic;

import java.util.HashMap;
import java.util.Map;

public class SongTransposer {
	private Map<String, String> transposeMap = new HashMap<>();
	private Map<String, String> enharmonicConfusion = new HashMap<>();

	/**
	 * constructor which also sets up the replacement map for the enharmonic
	 * confusion
	 */
	public void SongTransposer() {
		enharmonicConfusion.put("Des", "Cis");
		enharmonicConfusion.put("Es", "Dis");
		enharmonicConfusion.put("Ges", "Fis");
		enharmonicConfusion.put("As", "Gis");
		enharmonicConfusion.put("B", "Ais");

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

	public void prepare(String note) {

	}

	public static void main(String[] args) {
		String testString = "A B C H Fis";
		String extractedNote = "";

		SongTransposer songtranspo = new SongTransposer();
		songtranspo.buildLookupTable(-1);
		System.out.println(songtranspo.transposeMap.get("C"));

		// map.put("C", "D");
		// System.out.println(map.get("C"));

	}

}
