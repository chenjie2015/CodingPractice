package linkedin;

import java.util.ArrayList;
import java.util.List;

public class NumberFactorization {
	public static List<Integer> factorize(int num){
		List<Integer> factors = new ArrayList<Integer>();
		factors.add(1);
		for(int i = 2; i <= Math.ceil(Math.sqrt(num));){
			if(num % i == 0){
				factors.add(i);
				num /= i;
			} else
				i++;
		}
		return factors;
	}
	public static void main(String[] args){
		List<Integer> factors = factorize(32);
		for(int i = 0; i < factors.size(); i++)
			System.out.print(factors.get(i) + " ");
	}
}
