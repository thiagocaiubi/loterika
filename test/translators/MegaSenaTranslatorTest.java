package translators;

import java.util.Collection;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.Lottery;
import models.LotteryResult;

import org.junit.BeforeClass;
import org.junit.Test;

import play.test.UnitTest;

public class MegaSenaTranslatorTest extends UnitTest {

	private static final String RESPONSE_BODY = "1280|29.198.123,13|<span class=\"num_sorteio\"><ul><li>29</li><li>06</li><li>54</li><li>10</li><li>20</li><li>16</li></ul></span>|0|0,00|97|26.209,43|8.585|423,04|<a class=\"btn_conc_ant_megasena\" href=\"javascript:carrega_concurso(1279);\" tabindex=\"27\" title=\"Ver concurso anterior\">Ver concurso anterior</a>||04/05/2011|CONTAGEM|MG|C||1285|5|2.943.732,67||<span class=\"num_sorteio\"><ul><li>06</li><li>10</li><li>16</li><li>20</li><li>29</li><li>54</li></ul></span>|35.000.000,00|07/05/2011|20.994.302,63|43.424.628,00";

	private static Lottery lottery;
	
	@BeforeClass
	public static void beforeClass() {
		lottery = new MegaSenaTranslator(RESPONSE_BODY).translate();
	}
	
	@Test
	public void testNumber() throws Exception {
		assertEquals(1280, lottery.getNumber());
	}
	
	@Test
	public void testResult() throws Exception {
		Collection<LotteryResult> result = new HashSet<LotteryResult>();
		result.add(new LotteryResult(29));
		result.add(new LotteryResult(06));
		result.add(new LotteryResult(54));
		result.add(new LotteryResult(10));
		result.add(new LotteryResult(20));
		result.add(new LotteryResult(16));
		assertEquals(result, lottery.getResult());
	}
}