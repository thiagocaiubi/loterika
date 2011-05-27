package models;

import fetch.MegaSenaFetch;

public enum LotteryType {
	
	MEGA_SENA("Mega-Sena") {
		@Override
		public Lottery fetch() {
			return new MegaSenaFetch().fetch();
		}
	};
	
	public abstract Lottery fetch();
	
	private String name;

	private LotteryType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
