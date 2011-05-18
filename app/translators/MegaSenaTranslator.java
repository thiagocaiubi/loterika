package translators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.Lottery;
import models.LotteryResult;
import models.LotteryType;

public class MegaSenaTranslator implements Translator {

	private static final int NUMBER_INDEX = 0;
	private static final int RESULT_INDEX = 2;
	
	private String raw;
	
	public MegaSenaTranslator(String raw) {
		this.raw = raw;
	}

	public Lottery translate() {
		String[] chunks = this.raw.split("\\|");
		Lottery lottery = new Lottery();
		lottery.setLotteryType(LotteryType.MEGA_SENA);
		setNumber(chunks, lottery);
		setResult(chunks, lottery);
		return lottery;
	}

	private void setNumber(String[] chunks, Lottery lottery) {
		lottery.setNumber(Integer.valueOf(chunks[NUMBER_INDEX]));
	}
	
	private void setResult(String[] chunks, Lottery lottery) {
		String rawNumbers = chunks[RESULT_INDEX];
		Pattern pattern = Pattern.compile("\\d{2}");
		Matcher matcher = pattern.matcher(rawNumbers);
		while (matcher.find()) {
			LotteryResult lotteryResult = new LotteryResult(Integer.valueOf(matcher.group(0)));
			lottery.addResult(lotteryResult);
		}
	}
}