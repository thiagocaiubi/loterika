package models;

public class LotteryResult {

	private int number;

	public LotteryResult(int number) {
		setNumber(number);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
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
		LotteryResult other = (LotteryResult) obj;
		if (number != other.number)
			return false;
		return true;
	}
}