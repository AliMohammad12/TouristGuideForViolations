package Model;

public class Status {
	private String safety;
	private String cleanliness;
	private String residentsSanity;
	
	public Status() {
		this.safety = "safe";
		this.cleanliness = "clean";
		this.residentsSanity = "sane";
	}
	
	public String getSafety() {
		return safety;
	}
	public void setSafety(String safety) {
		this.safety = safety;
	}
	public String getCleanliness() {
		return cleanliness;
	}
	public void setCleanliness(String cleanliness) {
		this.cleanliness = cleanliness;
	}
	public String getResidentsSanity() {
		return residentsSanity;
	}
	public void setResidentsSanity(String residentsSanity) {
		this.residentsSanity = residentsSanity;
	}
	
}
