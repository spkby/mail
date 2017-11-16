public class Translit {

	private static final String charTable[];
	private static final char START_CHAR = 1025;

	public Translit() {
	}

	public static String toTranslit(String text) {
		char charBuffer[] = text.toCharArray();
		StringBuilder sb = new StringBuilder(text.length());
		char ac[];
		int k = (ac = charBuffer).length;
		for(int j = 0; j < k; j++) {
			char symbol = ac[j];
			int i = symbol - 1025;
			if(i >= 0 && i < charTable.length) {
				String replace = charTable[i];
				sb.append(replace != null ? ((Object) (replace)) : ((Object) (Character.valueOf(symbol))));
			} else {
				sb.append(symbol);
			}
		}

		return sb.toString();
	}

	static  {
		charTable = new String[81];
		charTable[15] = "A";
		charTable[16] = "B";
		charTable[17] = "V";
		charTable[18] = "G";
		charTable[19] = "D";
		charTable[20] = "E";
		charTable[0] = "E";
		charTable[21] = "Zh";
		charTable[22] = "Z";
		charTable[23] = "I";
		charTable[24] = "I";
		charTable[25] = "K";
		charTable[26] = "L";
		charTable[27] = "M";
		charTable[28] = "N";
		charTable[29] = "O";
		charTable[30] = "P";
		charTable[31] = "R";
		charTable[32] = "S";
		charTable[33] = "T";
		charTable[34] = "U";
		charTable[35] = "F";
		charTable[36] = "H";
		charTable[37] = "Ts";
		charTable[38] = "Ch";
		charTable[39] = "Sh";
		charTable[40] = "Sh";
		charTable[41] = "'";
		charTable[42] = "Y";
		charTable[43] = "'";
		charTable[44] = "E";
		charTable[45] = "U";
		charTable[46] = "Ya";
		for(int i = 0; i < charTable.length; i++) {
			char idx = (char)((char)i + 1025);
			char lower = (new String(new char[] {
				idx
			})).toLowerCase().charAt(0);
			if(charTable[i] != null) {
				charTable[lower - 1025] = charTable[i].toLowerCase();
			}
		}

	}
}
