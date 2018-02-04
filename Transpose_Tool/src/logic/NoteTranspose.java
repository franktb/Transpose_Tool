package logic;

/**
 * This Class transposes its given notes with the scheme of the quintcircle. the
 * algorithm is described here:
 * https://de.wikibooks.org/wiki/Musiklehre:_erweiterte_Transponiertabelle
 * 
 * @author frankadmin
 *
 */
public class NoteTranspose {
	// initialise the quintcircle array
	private String[] QuintCircleList = new String[21];

	/**
	 * constructor which also sets up the quintcircle
	 */
	public NoteTranspose() {
		QuintCircleList[0] = "Fes";
		QuintCircleList[1] = "Ces";
		QuintCircleList[2] = "Ges";
		QuintCircleList[3] = "Des";
		QuintCircleList[4] = "As";
		QuintCircleList[5] = "Es";
		QuintCircleList[6] = "B";
		QuintCircleList[7] = "F";
		QuintCircleList[8] = "C";
		QuintCircleList[9] = "G";
		QuintCircleList[10] = "D";
		QuintCircleList[11] = "A";
		QuintCircleList[12] = "E";
		QuintCircleList[13] = "H";
		QuintCircleList[14] = "Fis";
		QuintCircleList[15] = "Cis";
		QuintCircleList[16] = "Gis";
		QuintCircleList[17] = "Dis";
		QuintCircleList[18] = "Ais";
		QuintCircleList[19] = "Eis";
		QuintCircleList[20] = "C";

	}

	/**
	 * transposes the passed note with the given offset
	 * 
	 * @param Note
	 *            the note which will be transposed
	 * @param Offset
	 *            distance between the tonalities
	 * @return
	 */
	public String transpose(String Note, int Offset) {
		int curr = -100; // initalised with -100 so a Error is raised if the note isn't found
		String TransposedNote = null;
		// searches in the quintcircle for the note
		for (int i = 0; i < 21; i++) {
			if (QuintCircleList[i].equals(Note)) {
				curr = i;
				break;
			}
		}
		try {
			// gets the transposed note by using the offset(see wiki)
			TransposedNote = QuintCircleList[curr + Offset];
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Panic Mode, note string not found in quintcircle");
			TransposedNote = "Error";
		}
		return TransposedNote;
	}

	/**
	 * TODO nachdenken vllt kl negativer offset gut!!!!!!!!!!!!! 
	 * calculates the offset in the quintcircle
	 * 
	 * @param distance
	 *            the distance from source and target in big seconds(interval) like
	 *            from c to b its -1 small seconds are 0.5
	 * @return the calculated offset
	 */
	public int getOffset(int distance) {
		// the quintcircle is a modulo circle of 12
		int Offset = (distance * 10) % 12;
		// the offset has to between -6 and 7
		while (Offset < -6) {
			Offset = (Offset + 12) % 12;
		}
		while (Offset > 7) {
			Offset = (Offset - 12) % 12;
		}
		return Offset;
	}

	
	  public static void main(String[] args) { NoteTranspose mytranspo = new
	  NoteTranspose(); System.out.println(mytranspo.getOffset(-1));
	  System.out.println(mytranspo.transpose("F", mytranspo.getOffset(-1)));
	  
	  }
	 
}
