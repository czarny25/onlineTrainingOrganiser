package model;

public class Test {
	
	
	private String setId; // for checking
	private String setNo;
	private String reps;
	private String weight;
	
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Test(String setId, String setNo, String reps, String weight) {
		super();
		this.setId = setId;
		this.setNo = setNo;
		this.reps = reps;
		this.weight = weight;
	}

	public String getSetId() {
		return setId;
	}

	public void setSetId(String setId) {
		this.setId = setId;
	}

	public String getSetNo() {
		return setNo;
	}

	public void setSetNo(String setNo) {
		this.setNo = setNo;
	}

	public String getReps() {
		return reps;
	}

	public void setReps(String reps) {
		this.reps = reps;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Test [setId=" + setId + ", setNo=" + setNo + ", reps=" + reps + ", weight=" + weight + "]";
	}

	
	
}
