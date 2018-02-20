package com.mustafa.roman.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class RomanNumeralService {

	private List<RomanNumber> romanList = new ArrayList<>();
	{
		romanList.add(new RomanNumber(1_000_000, "M\u0305"));
		romanList.add(new RomanNumber(900_000, "C\u0305M\u0305"));
		romanList.add(new RomanNumber(500_000, "D\u0305"));
		romanList.add(new RomanNumber(400_000, "C\u0305D\u0305"));
		romanList.add(new RomanNumber(100_000, "C\u0305"));
		romanList.add(new RomanNumber(90_000, "X\u0305C\u0305"));
		romanList.add(new RomanNumber(50_000, "L\u0305"));
		romanList.add(new RomanNumber(40_000, "X\u0305L\u0305"));
		romanList.add(new RomanNumber(10_000, "X\u0305"));
		romanList.add(new RomanNumber(9_000, "I\u0305X\u0305"));
		romanList.add(new RomanNumber(5_000, "V\u0305"));
		romanList.add(new RomanNumber(4_000, "I\u0305V\u0305"));
		romanList.add(new RomanNumber(1_000, "M"));
		romanList.add(new RomanNumber(900, "CM"));
		romanList.add(new RomanNumber(500, "D"));
		romanList.add(new RomanNumber(400, "CD"));
		romanList.add(new RomanNumber(100, "C"));
		romanList.add(new RomanNumber(90, "XC"));
		romanList.add(new RomanNumber(50, "L"));
		romanList.add(new RomanNumber(40, "XL"));
		romanList.add(new RomanNumber(10, "X"));
		romanList.add(new RomanNumber(9, "IX"));
		romanList.add(new RomanNumber(5, "V"));
		romanList.add(new RomanNumber(4, "IV"));
		romanList.add(new RomanNumber(1, "I"));
	}

	public String numberToRoman(String numberInput) {
		StringBuilder returnValue = new StringBuilder();
		int[] number = new int[1];
		try {
			number[0] = Integer.parseInt(numberInput);
			romanList.forEach(map -> {
				while (number[0] >= map.getNumber()) {
					number[0] -= map.getNumber();
					returnValue.append(map.getRoman());
				}
			});
		} catch (NumberFormatException e) {
			return null;
		}
		return returnValue.toString();
	}

	public String romanToNumber(String roman) {
		if (!roman.matches("[MCDLVXI\\x{305}]+")) {
			return null;
		}
		Integer num = 0;
		final String regex = "((?:C\\x{305})?[MD]\\x{305}|(?:X\\x{305})?[CL]\\x{305}|(?:I\\x{305})?[XV]\\x{305}|C?[MD]|X?[CL]|I?[XV]|I)";
		final Pattern pattern = Pattern.compile(regex);
		final Matcher matcher = pattern.matcher(roman);
		int index = 0;
		while (matcher.find()) {
			if(matcher.group(1).equals(romanList.get(index).getRoman())){
				num += romanList.get(index).getNumber();
			} else {
				while(!matcher.group(1).equals(romanList.get(index).getRoman())) {
					index++;
				}
				num += romanList.get(index).getNumber();
			}
		}
		String checkRoman = numberToRoman(num.toString());
		if(checkRoman.equals(roman)) {
			return num.toString();
		}
		return null;
	}
}
