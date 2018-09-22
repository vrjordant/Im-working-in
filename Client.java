package Assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	public static Client generateRandom(int id, Map<WeightPlateSize, Integer> noOfWeightPlates) {
		// TODO: Implement me!
		return null;
	}
}
