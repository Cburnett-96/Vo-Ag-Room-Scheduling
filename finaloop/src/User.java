
public class User {
	private String Period, Monday, Tuesday, Wednesday, Thursday, Friday;

	public User(String Period, String Monday, String Tuesday, String Wednesday, String Thursday, String Friday) {

		this.Period = Period;
		this.Monday = Monday;
		this.Tuesday = Tuesday;
		this.Wednesday = Wednesday;
		this.Thursday = Thursday;
		this.Friday = Friday;
	}

	public String getPeriod() {
		return Period;
	}

	public String getMonday() {
		return Monday;
	}

	public String getTuesday() {
		return Tuesday;
	}

	public String getWednesday() {
		return Wednesday;
	}

	public String getThursday() {
		return Thursday;
	}

	public String getFriday() {
		return Friday;
	}
}
