package com.mustafa.roman.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class RomanNumeralService {

	public Map<Integer, String> returnRomanMap() {
		Map<Integer, String> romanList = new HashMap<>();
		romanList.put(1_000_000, "M\u0305");
		romanList.put(900_000, "C\u0305M\u0305");
		romanList.put(500_000, "D\u0305");
		romanList.put(400_000, "C\u0305D\u0305");
		romanList.put(100_000, "C\u0305");
		romanList.put(90_000, "X\u0305C\u0305");
		romanList.put(50_000, "L\u0305");
		romanList.put(40_000, "X\u0305L\u0305");
		romanList.put(10_000, "X\u0305");
		romanList.put(9_000, "I\u0305X\u0305");
		romanList.put(5_000, "V\u0305");
		romanList.put(4_000, "I\u0305V\u0305");
		romanList.put(1_000, "M");
		romanList.put(900, "CM");
		romanList.put(500, "D");
		romanList.put(400, "CD");
		romanList.put(100, "C");
		romanList.put(90, "XC");
		romanList.put(50, "L");
		romanList.put(40, "XL");
		romanList.put(10, "X");
		romanList.put(9, "IX");
		romanList.put(5, "V");
		romanList.put(4, "IV");
		romanList.put(1, "I");
		return romanList;
	}
	public String numberToRoman(String numberInput) {
		StringBuilder returnValue = new StringBuilder();
		Map<Integer, String> romanList = returnRomanMap();
		int[] number = new int[1];
		try {
			number[0] = Integer.parseInt(numberInput);
			romanList.entrySet().stream()
			.sorted((a,b)-> {
				if(a.getKey() > b.getKey()) 	return -1;
				else if(a.getKey() < b.getKey()) return 1;
				return 0;
			})
			.forEach(map -> {
				System.out.println(map.getKey() + " = " + map.getValue());
				while(number[0] >= map.getKey()) {
					number[0] -= map.getKey();
					returnValue.append(map.getValue());
				}
			});
		} catch (NumberFormatException e) {
			return null;
		}
		return returnValue.toString();
	}
	
	public String romanToNumber(String roman) {
		
		return null;
	}
}
