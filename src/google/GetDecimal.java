package google;

import java.util.ArrayList;
import java.util.HashMap;

public class GetDecimal {
	public static String getDecimal(int a, int b) {
		if (a == 0)
			return "0.0";
		if (b == 0)
			return "";
		StringBuilder res = new StringBuilder();
		res.append(a / b);
		res.append(".");
		int c = a;
		HashMap<Integer, Integer> mod = new HashMap<Integer, Integer>();
		ArrayList<Integer> decimals = new ArrayList<Integer>();
		int index = 0;
		while (c % b != 0 && !mod.containsKey(c % b)) {
			mod.put(c % b, index);
			c = c % b * 10;
			decimals.add(c / b);
			index++;
		}

		if (c % b == 0) {
			for (int i = 0; i < decimals.size(); i++)
				res.append(decimals.get(i));
			res.append("(0)");
		} else {
			index = mod.get(c % b);
			for (int i = 0; i < index; i++)
				res.append(decimals.get(i));
			res.append("(");
			for (int i = index; i < decimals.size(); i++)
				res.append(decimals.get(i));
			res.append(")");
		}
		return res.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(GetDecimal.getDecimal(2, 3));
		System.out.println(GetDecimal.getDecimal(1, 11));
		System.out.println(GetDecimal.getDecimal(1, 6));
		System.out.println(GetDecimal.getDecimal(1, 3));
		System.out.println(GetDecimal.getDecimal(13, 3));
		System.out.println(GetDecimal.getDecimal(1, 7));
		System.out.println(GetDecimal.getDecimal(7, 9));
		System.out.println(GetDecimal.getDecimal(1, 4));
	}
}
