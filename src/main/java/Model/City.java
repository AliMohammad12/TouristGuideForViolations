package Model;

public class City {
	private long Id;
	private String name;
	private Status status;
	private Violation violation;
	public City() {}
	public City(long id, String name, Status status) {
		super();
		Id = id;
		this.name = name;
		this.status = status;
	}
	public void updateStatus() {
		if (violation.getRunningStopSign() >= 10 || violation.getRedLightCrossing() >= 10) {
			status.setSafety("Dangerous");
		}
		if (violation.getJayWalking() >= 10) {
			status.setResidentsSanity("Insane");
		}
		if (violation.getLittering() >= 10) {
			status.setCleanliness("Dirty");
		}
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
