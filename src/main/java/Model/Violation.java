package Model;

public class Violation {
	int redLightCrossing;
	int runningStopSign;
	int jayWalking;
	int littering;	
	public Violation() {
		this.redLightCrossing = 0;
		this.runningStopSign = 0;
		this.jayWalking = 0;
		this.littering = 0;
	}
	public void addViolation(ViolationType violation) {			
		this.redLightCrossing += (violation == ViolationType.RedLightCrossing ? 1 : 0);
		this.runningStopSign += (violation == ViolationType.RunningStopSign ? 1 : 0);
		this.jayWalking += (violation == ViolationType.JayWalking ? 1 : 0);
		this.littering += (violation == ViolationType.Littering ? 1 : 0);
	}
	public int getRedLightCrossing() {
		return redLightCrossing;
	}
	public void setRedLightCrossing(int redLightCrossing) {
		this.redLightCrossing = redLightCrossing;
	}
	public int getRunningStopSign() {
		return runningStopSign;
	}
	public void setRunningStopSign(int runningStopSign) {
		this.runningStopSign = runningStopSign;
	}
	public int getJayWalking() {
		return jayWalking;
	}
	public void setJayWalking(int jayWalking) {
		this.jayWalking = jayWalking;
	}
	public int getLittering() {
		return littering;
	}
	public void setLittering(int littering) {
		this.littering = littering;
	}
	
}
