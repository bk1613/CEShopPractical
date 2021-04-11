package com.CE;

public class DeterminePalindrome {

	public static boolean checkPalindrome(String word) {
		
		String s = "";
		
		for(int i = word.length()-1; i > -1; i--) {
			s += word.charAt(i);
		}
		
		if(s.equals(word)) {
			return true;
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkPalindrome("stats"));
	}

}
