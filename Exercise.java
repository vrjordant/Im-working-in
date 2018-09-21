package Assignment2;

import java.util.Map;

public class Exercise {

	// Data structures
	private ApparatusType at;
	private Map<WeightPlateSize, Integer> weight;
	private int duration;
	
	public Exercise(ApparatusType at, Map<WeightPlateSize, Integer> weight, int duration) {
		// TODO: Implement me!
	}
	
	/**
	 * Generates a random exercise using the maximum number of plates in the argument
	 */
	public static Exercise generateRandom(Map<WeightPlateSize, Integer> weight) {
		// TODO: Implement me!
		return null;
	}
	
	// Exercises must be performed in the order of the routine
	// A routine may include the repeating use of an apparatus
	
	// To perform an exercise
	// 1. the required apparatus must be available and
	// 2. the required weight plates must be available (you can't sub 2 medium weights for 1 large weight)
	
	// Once a client finishes using an apparatus, she must unload all weights and release them for others to use.
	// They probably have to get out of the apparatus too
	
	
}
