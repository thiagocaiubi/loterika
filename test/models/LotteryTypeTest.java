package models;

import org.junit.Test;

import play.test.UnitTest;

public class LotteryTypeTest extends UnitTest {

	@Test
	public void testMegaSena() {
		assertEquals("Mega-Sena", LotteryType.MEGA_SENA.getName());
		assertEquals("Mega-Sena", LotteryType.MEGA_SENA.toString());
	}
}