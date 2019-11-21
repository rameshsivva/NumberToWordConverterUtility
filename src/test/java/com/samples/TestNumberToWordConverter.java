package com.samples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestNumberToWordConverter {

	@Test
	public void testNumber() {
		assertEquals(NumberToWordConverter.convert(56945781), "fifty six million nine hundred and forty five thousand seven hundred and eighty one");
	}
	
	@Test
	public void testOutOfRangeNumber() {
		assertEquals(NumberToWordConverter.convert(-1), "Enter number is out of range [0 and 999,999,999]. Please try again with a number within specified range.");
	}

}
