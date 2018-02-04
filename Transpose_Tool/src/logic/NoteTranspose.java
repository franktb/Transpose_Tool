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
	private String[] quintCircleList = new String[21];

	/**
	 * constructor which also sets up the quintcircle
	 */
	public NoteTranspose() {
		quintCircleList[0] = "F";
		quintCircleList[1] = "C";
		quintCircleList[2] = "G";
		quintCircleList[3] = "D";
		quintCircleList[4] = "A";
		quintCircleList[5] = "E";
		quintCircleList[6] = "H";
		quintCircleList[7] = "Fis";
		quintCircleList[8] = "Cis";
		quintCircleList[9] = "Gis";
		quintCircleList[10] = "Dis";
		quintCircleList[11] = "Ais";

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
		int curr = -1;
		int transposedIndex;
		String transposedNote;
		// searches in the quintcircle for the note
		for (int i = 0; i < 12; i++) {
			if (quintCircleList[i].equals(Note)) {
				curr = i;
				break;
			}
		}
		
		// gets the transposed note by using the offset(see wiki)
		transposedIndex = (curr +Offset)%12;
		while(transposedIndex < 0) {
			transposedIndex = (transposedIndex + 12) % 12;
		}
		
		transposedNote = quintCircleList[transposedIndex];
		
		return transposedNote;
	}

	/**
	 * calculates the offset in the quintcircle
	 * 
	 * @param distance
	 *            the distance from source and target in big seconds(interval) like
	 *            from c to b its -1 small seconds are 0.5
	 * @return the calculated offset
	 */
	public int getOffset(double distance) {
		// the quintcircle is a modulo circle of 12
			
		return (int)(distance * 10) % 12;
	}
	
	/*
	  public static void main(String[] args) { NoteTranspose mytranspo = new
	  NoteTranspose(); System.out.println(mytranspo.getOffset(-1));
	  System.out.println(mytranspo.transpose("F", mytranspo.getOffset(1.5)));
	  
	  }
	 */
}
