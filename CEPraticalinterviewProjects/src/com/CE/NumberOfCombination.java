package com.CE;

import java.util.ArrayList;
import java.util.List;

public class NumberOfCombination {
	
	
	public static void checksumtarget(List<Integer> li, int target, List<List<Integer>> nums) {
		int sum = 0;
		for(int k = 0; k < li.size(); k++) {
			sum += li.get(k);	
		}
		
				
		if(target == sum) {
			System.out.println(li);
			nums.add(li);
		}
	}
	
	public static List<List<Integer>> NumOfComb(int[] arr, int target, int i, List<Integer> li, List<List<Integer>> combo) {
		
		if(i == arr.length) {
			checksumtarget(li, target, combo);
			return combo;
		}
		if(!li.isEmpty()) {
			checksumtarget(li, target, combo);
		}
		for(int j = 0; j < arr.length; j++) {
			li.add(arr[j]);
			combo = NumOfComb(arr, target, i+1, li, combo);
			li.remove(li.size()-1);
		}
		
		return combo;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 4, 5, 7, 8};
		List<List<Integer>> nums = new ArrayList<>();
		NumOfComb(arr, 10, 0, new ArrayList<>(), nums);
		
	}

}
