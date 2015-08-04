package leetcode.blog;

public class Random7Random10 {
	// Q16 from random7() to random10()
	// E(# of call random7) is 2.45. We throw away idx from 41 to 49
	public static int random10(){
		int row, col, idx;
		do {
			row = random7();
			col = random7();
			idx = col + (row - 1) * 7;
		} while(idx > 40);
		return 1 + (idx - 1) % 10;
	}
	public static int random7(){
		return (int)(Math.random() * 7 + 1);
	}
	// E(# of call random7) is 2.21. We utilize integers from 41 to 49, and integers from 61 to 63
	public static int random10_better(){
		int row, col, idx;
		while(true){
			row = random7();
			col = random7();
			idx = col + (row - 1) * 7;
			if(idx <= 40)
				return 1 + (idx - 1) % 10;
			row = row - 40;
			col = random7();
			idx = col + (row - 1) * 7;
			if(idx <= 60)
				return 1 + (idx - 1) % 10;
			row = row - 60;
			col = random7();
			idx = col + (row - 1) * 7;
			if(idx <= 20)
				return 1 + (idx - 1) % 10;
		}
	}
}
