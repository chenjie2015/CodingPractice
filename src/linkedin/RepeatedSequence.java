package linkedin;

import java.util.HashSet;
import java.util.Iterator;

public class RepeatedSequence {
	public static int read(int index){
		if(index > 1000)
			return -1;
		int num = (int)(Math.random() * 26);
		return num + 'a';
	}
	public static int[] temp = new int[10];
	public static HashSet<String> findRepeatedSequences() throws Exception{
		int cur = 0;
		StringBuilder sb = new StringBuilder("");
		HashSet<Integer> set = new HashSet<Integer>();
		HashSet<String> result = new HashSet<String>();
		int random_index = 0;
		int index = 9;
		int hashCode = 0;
		do{
			cur = read(random_index++);
			char cur_char = (char)cur;
			if(sb.length() < 10)
				sb.append(cur_char);
			else{
				sb.deleteCharAt(0);
				sb.append(cur_char);
			}
			hashCode = calculateHash1(hashCode, index, cur_char);
			if(sb.length() == 10){
				String cur_string = sb.toString();
				if(hashCode < 0)
					throw new Exception("Error.");
				if(set.contains(hashCode))
					result.add(cur_string);
				else
					set.add(hashCode);
			}
		} while(cur != -1);
		return result;
	}
	public static int calculateHash1(int hashCode, int index, char cur_char){
		index = (index + 1) % 10;
		hashCode -= (temp[index] * Math.pow(31, 9));
		hashCode *= 31;
		temp[index] = (int)cur_char;
		hashCode += temp[index];
		return hashCode;
	}
	public static int calculateHash2(String cur_string){
		if(cur_string.length() != 10)
			return -1;
		int sum = 0;
		for(int i = 0; i < 10; i++){
			int value = (int)cur_string.charAt(i);
			sum = (int) (sum + value * Math.pow(31, 9 - i));
		}
		return sum;
	}
	public static void main(String[] args) throws Exception{
		HashSet<String> set = findRepeatedSequences();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}
}
