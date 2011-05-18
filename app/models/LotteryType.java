package models;

public enum LotteryType {
	
	MEGA_SENA("Mega-Sena");
	
	private String name;

	private LotteryType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
