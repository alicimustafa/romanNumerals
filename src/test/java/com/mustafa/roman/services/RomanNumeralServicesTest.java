package com.mustafa.roman.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RomanNumeralServicesTest {

	private RomanNumeralService rns;
	
	@Before
	public void setUp() {
		rns = new RomanNumeralService();
	}
	
	@After
	public void tearDown() {
		rns = null;
	}
	
	@Test
	public void smokeTest() {
		assertEquals(true, true);
	}
	
	@Test
	public void test_numberToRoman_translates_correctly() {
		assertEquals("XI", rns.numberToRoman("11"));
		assertEquals("XIV", rns.numberToRoman("14"));
	}
	
	@Test
	public void test_numberToRoman_returns_null_if_nonnumber() {
		assertNull(rns.numberToRoman("rt3"));
	}
	
	public void test_romanToNumber_translates_correctly() {
		assertEquals("123", rns.romanToNumber("CXXIII"));
		assertEquals("89", rns.romanToNumber("LXXXIX"));
	}

}
