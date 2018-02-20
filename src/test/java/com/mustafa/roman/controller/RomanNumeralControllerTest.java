package com.mustafa.roman.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.mustafa.roman.services.RomanNumeralService;

@RunWith(SpringRunner.class)
@WebMvcTest(RomanNumeralController.class)
public class RomanNumeralControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean	
	RomanNumeralService service;
	
	@Test
	public void smokeTest() {
		assertEquals(true, true);
	}
	
	@Test
	public void test_numberRoman_returns_roman() {
		when(service.numberToRoman("11")).thenReturn("XI");
		try {
			mvc.perform(post("/numberRoman").content("11"))
			.andExpect(status().isOk())
			.andExpect(content().string("XI"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_numberRoman_returns_badd_format_if_null() {
		when(service.numberToRoman("1a")).thenReturn(null);
		try {
			mvc.perform(post("/numberRoman").content("1a"))
			.andExpect(status().is4xxClientError())
			.andExpect(content().string("bad format"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_romanNumber_returns_correct_number() {
		when(service.romanToNumber("XIX")).thenReturn("19");
		try {
			mvc.perform(post("/romanNumber").content("XIX"))
			.andExpect(status().isOk())
			.andExpect(content().string("19"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_romanNumber_returns_bad_format_if_null() {
		when(service.romanToNumber("XIIIII")).thenReturn(null);
		try {
			mvc.perform(post("/romanNumber").content("XIIIII"))
			.andExpect(status().is4xxClientError())
			.andExpect(content().string("bad format"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
