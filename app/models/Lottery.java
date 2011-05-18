package models;

import java.util.Collection;
import java.util.LinkedHashSet;

public class Lottery {

	private int number;
	private Collection<LotteryResult> result = new LinkedHashSet<LotteryResult>();
	private LotteryType lotteryType;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public Collection<LotteryResult> getResult() {
		return result;
	}
	
	public void setResult(Collection<LotteryResult> result) {
		if (result != null && !result.isEmpty()) {
			this.result = result;
		}
	}

	public void addResult(LotteryResult lotteryResult) {
		result.add(lotteryResult);
	}
	
	public LotteryType getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lottery other = (Lottery) obj;
		if (number != other.number)
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		return true;
	}
}