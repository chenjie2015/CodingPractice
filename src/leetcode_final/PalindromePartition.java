package leetcode_final;

import java.util.ArrayList;
/*
 * Given a string s, partition s
 * such that every substring of the partition is a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return
 * 
 * [
 *  ["aa","b"],
 *  ["a","a","b"]
 * ]
 * 
 */
public class PalindromePartition {
	ArrayList<ArrayList<String>> res;
	ArrayList<String> partition;
	public ArrayList<ArrayList<String>> partition(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		res = new ArrayList<ArrayList<String>>();
		partition = new ArrayList<String>();
		partitioning(s);
		return res;
	}
	
	public void partitioning(String s) {
		int n = s.length();
		if (n == 0) {
			res.add(new ArrayList<String>(partition));
			return;
		}
		for (int i = 0; i < n; i++) {
			String begin = s.substring(0, i + 1);
			if (isPalindrome(begin)) {
				partition.add(begin);
				partitioning(s.substring(i + 1));
				partition.remove(partition.size() - 1);
			}
		}
	}

	public boolean isPalindrome(String s) {
		if (s.length() <= 1)
			return true;
		int begin = 0;
		int end = s.length() - 1;
		while (begin < end) {
			if (s.charAt(begin) == s.charAt(end)) {
				begin++;
				end--;
			} else
				return false;
		}
		return true;
	}
	
	// testing part
	public void print_outer(){
		for(int i = 0; i < res.size(); i++)
			System.out.println(res.get(i) + "!");
	}
	public void print_inner(){
		for(int i = 0; i < partition.size(); i++)
			System.out.println(partition.get(i) + "$");
	}
	public static void main(String[] args){
		PalindromePartition obj = new PalindromePartition();
		obj.partition("a");
	}
}
