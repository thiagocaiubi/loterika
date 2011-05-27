package models;

import org.junit.Test;

import play.test.UnitTest;

public class LotteryTypeTest extends UnitTest {

	@Test
	public void testName() {
		assertEquals("Mega-Sena", LotteryType.MEGA_SENA.getName());
	}
	
	@Test
	public void testToString() {
		assertEquals("MEGA_SENA", LotteryType.MEGA_SENA.toString());
	}
	
	@Test
	public void testToFetch() {
		assertNotNull(LotteryType.MEGA_SENA.fetch());
	}
}