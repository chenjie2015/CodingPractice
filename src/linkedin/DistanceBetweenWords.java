package linkedin;

import java.util.ArrayList;
import java.util.List;

public class DistanceBetweenWords {
	public static int minDis(String word1, String word2, List<String> list){
		int min = Integer.MAX_VALUE;
		int last1 = -1;
		int last2 = -1;
		for(int i = 0; i < list.size(); i++){
			String cur = list.get(i);
			if(word1.equals(cur)){
				last1 = i;
				if(last2 != -1)
					min = Math.min(Math.abs(last1 - last2), min);
			} else if (word2.equals(cur)){
				last2 = i;
				if(last1 != -1)
					min = Math.min(Math.abs(last1 - last2), min);
			}
		}
		return min;
	}
	public static void main(String[] args){
		ArrayList<String> list = new ArrayList<String>();
		list.add("purple");
		list.add("blue");
		list.add("orange");
		list.add("purple");
		list.add("green");
		list.add("purple");
		list.add("purple");
		list.add("green");
		list.add("dge");
		list.add("blue");
		System.out.println(minDis("blue", "green", list));
		System.out.println(minDis("green", "blue", list));
		System.out.println(minDis("blue", "green", list));
	}
}
