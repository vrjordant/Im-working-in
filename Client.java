package Assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Client {

	// Data structures
	private int id;
	private List<Exercise> routine;
	
	public Client(int id) {
		this.id = id;
		routine = new ArrayList<Exercise>();
	}
	
	public void addExercise(Exercise e) {
		routine.add(e);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Exercise> getRoutine() {
		return routine;
	}

	public void setRoutine(List<Exercise> routine) {
		this.routine = routine;
	}

	/*
	 * Generates a random client with the given id
	 */
	public static Client generateRandom(int id) {
		Client newGuy = new Client(id); 
		Random exerciseAmt = new Random();
		int exerciseNum = exerciseAmt.nextInt(6)+15;
		for( int i = 0; i<exerciseNum; i++) {
			newGuy.addExercise(Exercise.generateRandom());
		}
		return newGuy;
	}
	
	 @Override
	    public String toString() { 
	        return String.format(id + " : " + routine.toString()); 
	    } 
	public static void main(String[] args){
		System.out.println(Client.generateRandom(2));
	}
}
