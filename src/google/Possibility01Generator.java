package google;
/*
 * 1/(2^n) possibility return 1
 * other return 0
 */
public class Possibility01Generator {
	public static int random(){
		return (int)(Math.random() + 0.5);
	}
	public static int random2(int n){
		if(n == 1)
			return random();
		int i = random();
		if(i == 0)
			return 0;
		else
			return random2(n - 1);
	}
}
