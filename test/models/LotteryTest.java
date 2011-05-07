package models;

import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;

import play.test.UnitTest;

public class LotteryTest extends UnitTest {

	@Test
	public void testNumber() {
		int number = 1234;
		Lottery lottery = new Lottery();
		lottery.setNumber(number);
		assertEquals(number, lottery.getNumber());
	}
	
	@Test
	public void testResult() {
		Lottery lottery = new Lottery();
		
		lottery.setResult(null);
		assertNotNull(lottery.getResult());
		assertTrue(lottery.getResult().isEmpty());
		
		lottery.setResult(new HashSet<LotteryResult>());
		assertNotNull(lottery.getResult());
		assertTrue(lottery.getResult().isEmpty());
		
		LotteryResult one = new LotteryResult(1);
		
		Collection<LotteryResult> result = new HashSet<LotteryResult>();
		result.add(one);
		lottery.setResult(result);
		assertFalse(lottery.getResult().isEmpty());
		assertEquals(one, lottery.getResult().iterator().next());
		
		lottery.addResult(one);
		assertFalse(lottery.getResult().isEmpty());
		assertEquals(one, lottery.getResult().iterator().next());
	}
}