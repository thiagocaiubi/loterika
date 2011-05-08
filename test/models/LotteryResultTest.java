package models;

import org.junit.Test;

import play.test.UnitTest;

public class LotteryResultTest extends UnitTest {

	@Test
	public void testNumber() {
		int number = 1;
		LotteryResult result = new LotteryResult(number);
		result.setNumber(number);
		assertEquals(number, result.getNumber());
	}
}
