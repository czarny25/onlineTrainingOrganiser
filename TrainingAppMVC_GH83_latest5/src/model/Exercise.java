package model;

import java.util.List;

//import org.codehaus.jackson.annotate.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Exercise {
	
	private String nameOfExercise;
	private List <Set> sets;
	private int groupId;
	
	
	
	public Exercise() {
		
	}

	public Exercise(String nameOfExercise, List<Set> sets) {
		super();
		this.nameOfExercise = nameOfExercise;
		this.sets = sets;
	}
	
	public String getNameOfExercise() {
		return nameOfExercise;
	}
	public void setNameOfExercise(String nameOfExercise) {
		this.nameOfExercise = nameOfExercise;
	}
	
	public List<Set> getSets() {
		return sets;
	}
	public void setSets(List<Set> sets) {
		this.sets = sets;
	}
//	@Override
//	public String toString() {
//		return " " + nameOfExercise + "\n" + sets;
////				+ "\n    groupId=" + groupId + "\n";
//	}
	
	@Override
	public String toString() {
		return String.format("{nameOfExercise:%s,sets:%s}", nameOfExercise, sets);
	}
	
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	 
	 
}
