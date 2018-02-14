package com.mustafa.roman.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mustafa.roman.services.RomanNumeralService;

@RestController
public class RomanNumeralController {

	@Autowired
	private RomanNumeralService romanService;
	
	@RequestMapping("/ping")
	public String ping() {
		return "pong this";
	}
	
	@RequestMapping(path="/numberRoman", method = RequestMethod.POST)
	public String numberToRoman(@RequestBody String number, 
			HttpServletResponse res) {
		String result = romanService.numberToRoman(number);
		if(result == null) {
			res.setStatus(406);
			return "bad format";
		}
		return result;
	}
	
	@RequestMapping(path="/romanNumber", method = RequestMethod.POST)
	public String romanToNumber(@RequestBody String roman,
			HttpServletResponse res) {
		String result = romanService.romanToNumber(roman);
		if(result == null) {
			res.setStatus(406);
			return "bad format";
		}
		return result;
	}
}
