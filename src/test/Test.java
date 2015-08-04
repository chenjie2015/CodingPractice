package test;

import facebook.UserLogs;

public class Test {
	public UserLogs instance = new UserLogs();

	/*
	 * public int test(){ return instance.test(); }
	 */

	public static void main(String[] args) {
		String s = "abc";
		String s1 = s + "";
		String s2 = "ab" + "c";
		System.out.println(s == s1);// false
		System.out.println(s == s2);// true
		System.out.println(count(8));
		System.out.println(count(7));
	}
	
	public static int count(int a){
		int counter = 0;
		while(a != 0){
			if((a & 0x1) != 0)
				counter++;
			a = a >> 1;
		}
		return counter;
	}
}
