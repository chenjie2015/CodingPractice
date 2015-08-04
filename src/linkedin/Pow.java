package linkedin;

public class Pow {
	public double pow(double x, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(n == 0)
			return 1;
		if(x == 0)
			return 0;
		boolean sign = false;
		if(n < 0){
			sign = true;
			n = - n;
		}
		double temp = x;
		double result = 1;
		while(n > 0){
			if((n & 1) > 0)// even or odd
				result *= temp;
			temp *= temp;
			n >>= 1;
		}
		return sign ? 1.0 / result : result;
	}
	public static void main(String[] args){
		Pow test = new Pow();
		test.pow(10, 7);
	}
}
