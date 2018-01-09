package model;

public class Set {
	
//	private int setId; // for checking
	private int setNo;
	private int reps;
	private double weight;
	
	public Set() {
	}
	
	public Set(int reps, double weight) {		
		this.reps = reps;
		this.weight = weight;
	}
	
//	public Set(int setNo, int reps, double weight) {
//		this.setNo = setNo;
//		this.reps = reps;
//		this.weight = weight;
//	}

	
	public Set(int setId, int setNo, int reps, double weight) {		
//		this.setId = setId;
		this.setNo = setNo;
		this.reps = reps;
		this.weight = weight;
	}

//	public int getSetId() {
//		return setId;
//	}
//
//	public void setSetId(int setId) {
//		this.setId = setId;
//	}

	
	public int getSetNo() {
		return setNo;
	}

	public void setSetNo(int setNo) {
		this.setNo = setNo;
	}

	public int getReps() {
		return reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

//	@Override
//	public String toString() {
//		return "    " + setNo + ". " + reps + " . " + weight + ".\n";
//	}
	
	@Override
	public String toString() {
		return String.format("{setNo:%s,reps:%s,weight:%s}", setNo, reps, weight);
	}
	

}
