package linkedin;

import java.util.HashSet;
import java.util.Iterator;

public class RepeatedSequenceAdvanced {

	public static int j = 0;
	public static String test = "abcdefghijuuuuuuuabcdefghij";
	public static int read() {
		if(j == test.length())
			return -1;
		return test.charAt(j++);
	}

	public static int[] temp = new int[10];

	public static HashSet<String> findRepeatedSequences() throws Exception {
		int cur = 0;
		HashSet<Long> set = new HashSet<Long>();
		HashSet<String> result = new HashSet<String>();
		int index = 9;
		long hashCode = 0;
		do {
			cur = read();
			char cur_char = (char) cur;
			index = (index + 1) % 10;
			hashCode = calculateHash(hashCode, index, cur_char);
			if (temp[9] != 0) {
				if (hashCode < 0)
					throw new Exception("Error.");
				if (set.contains(hashCode))
					result.add(getString(index));
				else
					set.add(hashCode);
			}
		} while (cur != -1);
		return result;
	}

	public static long calculateHash(long hashCode, int index, char cur_char) {
		hashCode -= (temp[index] * Math.pow(31, 9));
		hashCode *= 31;
		temp[index] = (int) (cur_char - 'a' + 1);
		hashCode += temp[index];
		return hashCode;
	}

	public static String getString(int index){
		StringBuilder sb = new StringBuilder("");
		int i = 0;
		while(i < 10){
			index = (index + 1) % 10;
			sb.append((char)(temp[index] + 'a' - 1));
			i++;
		}
		return sb.toString();
	}
	public static void main(String[] args) throws Exception {
		HashSet<String> set = findRepeatedSequences();
		Iterator<String> it = set.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}

}
