package google;

import java.util.ArrayList;

/*
 * implement java iterator interface
 * input : 11223344
 * output : 1223334444
 */
public class NumberInterator {
	private ArrayList<Integer> list;
	private int index;
	private int value;
	private int count;

	public NumberInterator(ArrayList<Integer> list) {
		this.list = list;
		if(list.size() != 0){
			value = list.get(0);
			count = value;
			index = 0;
			while(index < list.size() && list.get(index++) == value);
		}
	}

	public boolean hasNext() {
		return index < list.size() || count != 0;
	}

	public Integer next() {
		if (count > 0) {
			count--;
			return value;
		} else {
			value = list.get(index);
			count = value - 1;
			while(index < list.size() && list.get(index++) == value);
			return value;
		}
	}

	public void remove() {
	}

	public static void main(String args[]) {
		// ArrayList<Integer> input = new ArrayList<Integer>();
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(1);
		input.add(2);
		input.add(2);
		input.add(3);
		input.add(3);
		input.add(4);
		input.add(4);
		NumberInterator it = new NumberInterator(input);
		while (it.hasNext())
			System.out.println(it.next());
	}

}
