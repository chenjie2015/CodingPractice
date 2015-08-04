package CTCI;

public class Chapter1 {
	public boolean isUniqueChars2(String str) {
		if (str.length() > 256)
			return false;
		boolean[] charSet = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			if (charSet[str.charAt(i)])
				return false;
			charSet[i] = true;
		}
		return true;
	}

	// Assume only 'a' to 'z', and use bit manipulation
	public boolean isUniqueChars(String str) {
		if (str.length() > 26)
			return false;
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) == 0)
				return false;
			checker |= 1 << val;
		}
		return true;
	}
	
	public boolean permutation(String str1, String str2){
		char[] str1Char = str1.toCharArray();
		char[] str2Char = str2.toCharArray();
		
		return true;
	}
	
	public String sortString(String str){
		char[] strChar = str.toCharArray();
		java.util.Arrays.sort(strChar);
		return new String(strChar);
	}
}
