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
}
